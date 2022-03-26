package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;
import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.api.enums.BillStatus;
import jp.co.nss.hrm.backend.api.service.ReagentRefundService;
import jp.co.nss.hrm.backend.mapper.*;
import jp.co.nss.hrm.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReagentRefundServiceImpl implements ReagentRefundService {


    @Autowired
    private ReagentRefundMapper refundMapper;

    @Autowired
    private ReagentStockMapper stockInfoMapper;

    @Autowired
    private ReagentStockDao stockInfoDao;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentRefundDetailDao refundDetailDao;

    @Autowired
    private ReagentRefundDetailItemDao refundDetailItemDao;

    @Autowired
    private ReagentRefundDao refundDao;

    @Autowired
    private ReagentStockDao stockDao;

    @Autowired
    private ReagentStockDetailMapper stockDetailMapper;

    @Autowired
    private ReagentOutBillMapper outBillMapper;

    @Autowired
    private ReagentOutDetailMapper outDetailMapper;

    @Autowired
    private ReagentOutDetailDao outDetailDao;

    @Autowired
    private ReagentOutItemDao outItemDao;

    @Autowired
    private ReagentInBillMapper inBillMapper;

    @Autowired
    private ReagentInDetailDao inDetailDao;

    @Autowired
    private ReagentInDetailItemDao inItemDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    /**
     * 获取所有领用列表
     */
    @Override
    public List<ReagentRefund> list() {

        return refundMapper.selectByExample(new ReagentRefundExample());
    }

    /**
     * 分页获取领用详细信息
     *
     * @param startTime
     * @param endTime
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentRefund> searchByDate(String startTime, String endTime, String refundType, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return refundDao.searchByDate(startTime, endTime, refundType);
    }

    /**
     * 添加退货信息
     *
     * @param refund
     */
    @Override
    public int create(ReagentRefundPost refund) {
        String refundType = refund.getRefundType();//退货类型
        /*String stockType = refund.getStockType(); //库存类型
        String stockInType = refund.getStockCInType(); //写入二级中心库类型
        String billType = refund.getBillType();  //出库类型
        String inType = refund.getInType();//入库类型
        String refundStatus = refund.getRefundStatus();  //退货状态*/
        String username = refund.getCreateBy();
        String branch = adminDao.selectBranch(username);
        List<ReagentRefundMess> refundMessList = refund.getRefundMessList();
        List<String> stockInfos = new ArrayList<>();
        refundMessList.forEach(item -> {
            stockInfos.add(item.getStockNo());
        });

        // 记录所需退货的数据,用于出库
        /*
        Map<String, List<ReagentStockDetail>> refundData = new HashMap<>();
        // 开始操作
        refundMessList.forEach(refundItem -> {
            List<ReagentStockDetail> alterStockDetailList = refundDao.getAlterStockList(refundItem.getReagentId(), refundItem.getQuantity());
            refundData.put(refundItem.getReagentId(), alterStockDetailList);
        });
        System.out.println("refundData:" + refundData);
        */

        // 退货
        ReagentStockExample stockInfoExample = new ReagentStockExample();
        ReagentStockExample.Criteria criteria = stockInfoExample.createCriteria();
        criteria.andStockNoIn(stockInfos);

        // 存储所有申请单详细信息，面向中心库
        List<ReagentStock> stockList = stockInfoMapper.selectByExample(stockInfoExample);

        //按供应商ID分组
        Map<String, List<ReagentPreRefund>> stockInfoList = new HashMap<>();
        refundMessList.forEach(item -> {
            //判断新增加的药剂是否已经有对应的供应商订单
            if (stockInfoList.containsKey(item.getSupplierShortName())) {
                stockList.forEach(stockInfoItem -> {
                    if (stockInfoItem.getStockNo().equals(item.getStockNo())) {
                        ReagentPreRefund reagentPreRefund = new ReagentPreRefund();
                        reagentPreRefund.setInfo(stockInfoItem);
                        reagentPreRefund.setInfoNumber(item.getQuantity());
                        stockInfoList.get(item.getSupplierShortName()).add(reagentPreRefund);
                    }
                });
            } else {//如果没有，创建一条新的订单信息,里面包含订单详细和数量
                stockList.forEach(stockInfoItem -> {
                    if (stockInfoItem.getStockNo().equals(item.getStockNo())) {
                        ReagentPreRefund reagentPreRefund = new ReagentPreRefund();
                        reagentPreRefund.setInfo(stockInfoItem);
                        reagentPreRefund.setInfoNumber(item.getQuantity());
                        List<ReagentPreRefund> list = new ArrayList<>();
                        list.add(reagentPreRefund);
                        stockInfoList.put(item.getSupplierShortName(), list);
                    }
                });
            }
        });

        //库存第二层数据查询
        ReagentStockDetailExample stockDetailExample = new ReagentStockDetailExample();
        ReagentStockDetailExample.Criteria detailCriteria = stockDetailExample.createCriteria();
        detailCriteria.andStockNoIn(stockInfos);

        List<ReagentStockDetail> stockDetailListAll = stockDetailMapper.selectByExample(stockDetailExample);

        List<ReagentStockDetail> stockDetailInfoList = new ArrayList<>();
        refundMessList.forEach(refundMessItem -> {
            AtomicInteger item = new AtomicInteger(0);
            stockDetailListAll.forEach(stockDetailItem -> {
                int i = item.get();
                if (stockDetailItem.getStockNo().equals(refundMessItem.getStockNo())) {
                    if (i < refundMessItem.getQuantity()) {
                        stockDetailInfoList.add(stockDetailItem);
                        item.incrementAndGet();
                    }
                }
            });
        });

        try {
            stockInfoList.forEach((item, messList) -> {
/*                // 一级二级中心库退货，中心库库存数量变动
                if (refundType.equals("1") || refundType.equals("2")) {
                    final int[] quantity = {0};
                    messList.forEach(stockLists -> {
                        refundMessList.forEach(messItem -> {
                            if (stockLists.getInfo().getStockNo().equals(messItem.getStockNo())) {
                                quantity[0] = (int) (stockLists.getInfo().getQuantity() - messItem.getQuantity());
                                stockInfoDao.updateQBySN(stockLists.getInfo().getStockNo(), quantity[0]);
                                stockDetailDao.deleteDetailByQuantity(stockLists.getInfo().getStockNo(), messItem.getQuantity());
                            }
                        });
                    });
                } else if (refundType.equals("3")) {
                    // 二级科室库退货，科室库库存数量变动
                    final int[] quantity = {0};
                    messList.forEach(stockLists -> {
                        refundMessList.forEach(messItem -> {
                            if (stockLists.getInfo().getStockNo().equals(messItem.getStockNo())) {
                                quantity[0] = (int) (stockLists.getInfo().getQuantity() - messItem.getQuantity());
                                stockInfoDao.updateQBySN(stockLists.getInfo().getStockNo(), quantity[0]);
                                stockDetailDao.deleteDetailByQuantity(stockLists.getInfo().getStockNo(), messItem.getQuantity());
                            }
                        });
                    });
                }*/

                // 退货单对象
                ReagentRefund refundItem = new ReagentRefund();
                refundItem.setCreateTime(new Date());
                refundItem.setRefundType(refundType);
                refundItem.setRemark(refund.getRemark());
                refundItem.setCreateBy(refund.getCreateBy());
                refundItem.setSupplierShortName(messList.get(0).getInfo().getSupplierName());
                refundItem.setBranch(branch);
                double totalPrice = messList.stream().mapToDouble(priceItem -> priceItem.getInfoNumber().longValue() * priceItem.getInfo().getReagentPrice()).sum();
                double quantity = messList.stream().mapToDouble(priceItem -> priceItem.getInfoNumber().longValue()).sum();
               /* double total = 0;
                final int[] number = {0};
                //使用增强for循环吧, 之前用的是stream式循环 8 后更新的 可能调用外部变量方式不同
                for (ReagentRefundMess listItem : refundMessList) {
                    total += listItem.getReagentPrice() * listItem.getQuantity();
                    number[0] += listItem.getQuantity();
                }
                refundItem.setQuantity((long) number[0]);
                refundItem.setTotal(total);*/

                refundItem.setQuantity((long) quantity);
                refundItem.setTotal(totalPrice);
                refundItem.setBranch(branch);

                Long time1 = new Date().getTime();
                Random ne2 = new Random();//实例化一个random的对象ne
                int x2 = ne2.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                String random_order2 = String.valueOf(x2);
                String refundCode = time1 + random_order2;
                refundItem.setRefundCode(refundCode);

                int result = refundMapper.insert(refundItem);

                // 写入退货单详细表
                List<ReagentRefundDetail> reagentRefundDetailList = new ArrayList<>();
                refundMessList.forEach(refundMessItem -> {
                    messList.forEach(stockInfoItem -> {
                        if (refundMessItem.getStockNo().equals(stockInfoItem.getInfo().getStockNo())) {

                            Long time2 = new Date().getTime();
                            Random ne3 = new Random();//实例化一个random的对象ne
                            int x3 = ne3.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                            String random_order3 = String.valueOf(x3);
                            String refundDetailId = time2 + random_order3;

                            ReagentRefundDetail refundDetail = new ReagentRefundDetail();
                            refundDetail.setRefundCode(refundCode);
                            refundDetail.setRefundDetailId(refundDetailId);
                            refundDetail.setReagentId(stockInfoItem.getInfo().getReagentId());
                            refundDetail.setReagentName(stockInfoItem.getInfo().getReagentName());
                            refundDetail.setReagentSpecification(stockInfoItem.getInfo().getReagentType());

                            //根据库存编号将库存与库存详细对应，以查找试剂的批号和注册证号
                            stockDetailInfoList.forEach(stockDetailItem -> {
                                if (stockInfoItem.getInfo().getStockNo().equals(stockDetailItem.getStockNo())) {
                                    refundDetail.setBatchNo(stockDetailItem.getBatchNo());
                                    refundDetail.setRegistrationNo(stockDetailItem.getRegistrationNo());
                                }
                            });

                            refundDetail.setFactory(stockInfoItem.getInfo().getFactory());
                            refundDetail.setSupplierShortName(stockInfoItem.getInfo().getSupplierName());
                            refundDetail.setReagentUnit(stockInfoItem.getInfo().getReagentUnit());
                            refundDetail.setReagentPrice(refundMessItem.getReagentPrice());
                            refundDetail.setQuantity(refundMessItem.getQuantity().longValue());
                            double reagentTotal = refundMessItem.getReagentPrice() * refundMessItem.getQuantity();
                            refundDetail.setTotal(reagentTotal);
                            refundDetail.setCreateTime(new Date());
                            refundDetail.setCreateBy(refund.getCreateBy());
                            reagentRefundDetailList.add(refundDetail);
                            // 写入退货单详情表
                            /*List<ReagentRefundDetailItem> refundDetailItemList = new ArrayList<>();
                            stockDetailInfoList.forEach(stockDetailItem -> {
                                if (stockInfoItem.getInfo().getStockNo().equals(stockDetailItem.getStockNo())) {
                                    ReagentRefundDetailItem refundDetailItem = new ReagentRefundDetailItem();
                                    refundDetailItem.setRefundCode(refundCode);
                                    refundDetailItem.setRefundDetailId(refundDetailId);
                                    refundDetailItem.setQrCode(stockDetailItem.getQrCode());
                                    refundDetailItem.setCodeValue(stockDetailItem.getCodeValue());
                                    refundDetailItem.setReagentCode(stockDetailItem.getReagentCode());
                                    refundDetailItem.setCreateBy(refund.getCreateBy());
                                    refundDetailItem.setStatus(refundStatus);
                                    refundDetailItemList.add(refundDetailItem);
                                }
                            });
                            refundDetailItemDao.insertItem(refundDetailItemList);*/
                        }
                    });
                });
                refundDetailDao.insertRefundDetail(reagentRefundDetailList);
            });

            // 写入入库单及二级中心库
    /*         if (inType != null) {
                //第一层入库插入
                ReagentInBill inBill = new ReagentInBill();

                int inRandom = new Random().nextInt(100);
                Long inTime = new Date().getTime();
                String inBillCode = String.valueOf(inRandom) + String.valueOf(inTime);
                inBill.setBillCode(inBillCode);
                inBill.setBillType(inType);
                inBill.setBillDate(new Date());
                inBill.setBillCreator(refund.getCreateBy());
                inBill.setRemark(refund.getRemark());
                inBill.setBillStatus(refund.getRefundStatus());
                inBill.setUpdateTime(new Date());

                refundMessList.forEach(refundMessItem -> {
                    stockList.forEach(stockInfoItem -> {
                        if (refundMessItem.getStockNo().equals(stockInfoItem.getStockNo())) {
                            inBill.setSupplierId(stockInfoItem.getReagentId());
                            inBill.setSupplierShortName(stockInfoItem.getSupplierName());
                        }
                    });
                });
                inBillMapper.insert(inBill);

                //入库二层
                List<ReagentInDetail> reagentInDetailList = new ArrayList<>();
                refundMessList.forEach(refundMessItem -> {
                    stockList.forEach(stockDetailInfoItem -> {
                        if (refundMessItem.getStockNo().equals(stockDetailInfoItem.getStockNo())) {
                            int inRandom2 = new Random().nextInt(100);
                            Long inTemp = new Date().getTime();
                            String inDetailId = String.valueOf(inRandom2) + String.valueOf(inTemp);

                            ReagentInDetail inDetail = new ReagentInDetail();
                            inDetail.setBillCode(inBillCode);
                            inDetail.setInDetailId(inDetailId);
                            inDetail.setReagentName(stockDetailInfoItem.getReagentName());
                            inDetail.setReagentUnit(stockDetailInfoItem.getReagentUnit());
                            inDetail.setReagentSpecification(stockDetailInfoItem.getReagentType());
                            inDetail.setPrice(refundMessItem.getReagentPrice());
                            inDetail.setQuantity(refundMessItem.getQuantity().longValue());

                            double inTotal = refundMessItem.getReagentPrice() * refundMessItem.getQuantity();
                            inDetail.setTotal(inTotal);
                            //根据库存编号将库存与库存详细对应，以查找试剂的批号和注册证号
                            stockDetailInfoList.forEach(stockDetailItem -> {
                                if (stockDetailInfoItem.getStockNo().equals(stockDetailItem.getStockNo())) {
                                    inDetail.setBatchNo(stockDetailItem.getBatchNo());
                                    inDetail.setExpireDate(stockDetailItem.getExpireDate());
                                }
                            });
                            inDetail.setRemark(refund.getRemark());
                            reagentInDetailList.add(inDetail);

                            // 入库第三层
                            List<ReagentInDetailItem> inDetailItemList = new ArrayList<>();

                            stockDetailInfoList.forEach(stockDetailItem -> {
                                if (stockDetailInfoItem.getStockNo().equals(stockDetailItem.getStockNo())) {
                                    ReagentInDetailItem inDetailItem = new ReagentInDetailItem();

                                    inDetailItem.setBillCode(inBillCode);
                                    inDetailItem.setInDetailId(inDetailId);
                                    inDetailItem.setCreateTime(new Date());
                                    inDetailItem.setReagentCode(stockDetailItem.getReagentCode());
                                    inDetailItem.setQrCode(stockDetailItem.getQrCode());
                                    inDetailItem.setCodeValue(stockDetailItem.getCodeValue());
                                    inDetailItem.setCreateBy(refund.getCreateBy());
                                    inDetailItem.setStatus(stockDetailInfoItem.getReagentStatus());
                                    inDetailItemList.add(inDetailItem);

                                }
                                //item.incrementAndGet();
                            });
                            inItemDao.insertBillItem(inDetailItemList);
                        }
                    });
                });
                inDetailDao.insertInDetail(reagentInDetailList);

                //写入二级中心库
                List<ReagentStock> reagentStockList = new ArrayList<>();
                refundMessList.forEach(refundMessItem -> {
                    stockList.forEach(stockInfoItem -> {
                        if (refundMessItem.getStockNo().equals(stockInfoItem.getStockNo())) {
                            //第一层
                            ReagentStock reagentStock = new ReagentStock();
                            int random = new Random().nextInt(100);
                            Long time2 = new Date().getTime();
                            String stockNo = String.valueOf(random) + String.valueOf(time2);
                            reagentStock.setStockNo(stockNo);
                            reagentStock.setStockType(stockInType);
                            reagentStock.setReagentId(stockInfoItem.getReagentId());
                            reagentStock.setReagentName(stockInfoItem.getReagentName());
                            reagentStock.setReagentType(stockInfoItem.getReagentType());
                            reagentStock.setReagentUnit(stockInfoItem.getReagentUnit());
                            reagentStock.setFactory(stockInfoItem.getFactory());
                            reagentStock.setSupplierName(stockInfoItem.getSupplierName());
                            reagentStock.setQuantity(refundMessItem.getQuantity().longValue());
                            reagentStock.setReagentPrice(refundMessItem.getReagentPrice());
                            reagentStock.setReagentTemp(stockInfoItem.getReagentTemp());
                            reagentStock.setLowStock(stockInfoItem.getLowStock());
                            reagentStock.setOverdueStock(stockInfoItem.getOverdueStock());

                            reagentStockList.add(reagentStock);

                            //第二层
                            List<ReagentStockDetail> reagentStockDetailList = new ArrayList<>();
                            stockDetailInfoList.forEach(stockDetailItem -> {
                                if (stockInfoItem.getStockNo().equals(stockDetailItem.getStockNo())) {
                                    ReagentStockDetail reagentStockDetail = new ReagentStockDetail();

                                    reagentStockDetail.setStockNo(stockNo);
                                    reagentStockDetail.setStockType(stockInType);
                                    reagentStockDetail.setReagentId(stockInfoItem.getReagentId());
                                    reagentStockDetail.setReagentName(stockInfoItem.getReagentName());
                                    reagentStockDetail.setSpecification(stockInfoItem.getReagentType());

                                    reagentStockDetail.setManufacturerName(stockInfoItem.getFactory());
                                    reagentStockDetail.setRegistrationNo(stockDetailItem.getRegistrationNo());
                                    reagentStockDetail.setSupplierShortName(stockInfoItem.getSupplierName());
                                    reagentStockDetail.setReagentUnit(stockInfoItem.getReagentUnit());
                                    reagentStockDetail.setReagentStatus(stockInfoItem.getReagentStatus());
                                    reagentStockDetail.setReagentTemp(stockInfoItem.getReagentTemp());

                                    reagentStockDetail.setReagentCode(stockDetailItem.getReagentCode());
                                    reagentStockDetail.setQrCode(stockDetailItem.getQrCode());
                                    reagentStockDetail.setCodeValue(stockDetailItem.getCodeValue());
                                    reagentStockDetail.setBatchNo(stockDetailItem.getBatchNo());
                                    reagentStockDetail.setExpireDate(stockDetailItem.getExpireDate());

                                    reagentStockDetail.setOpenPeriod(stockDetailItem.getOpenPeriod());
                                    reagentStockDetail.setReagentPrice(stockDetailItem.getReagentPrice());
                                    reagentStockDetail.setOverdue(stockDetailItem.getOverdue());

                                    reagentStockDetail.setEnterTime(new Date());
                                    reagentStockDetail.setEnterNo(inBillCode);
                                    reagentStockDetail.setEnterMan(refund.getCreateBy());
                                    reagentStockDetail.setCreateTime(new Date());
                                    reagentStockDetail.setCreateBy(refund.getCreateBy());

                                    reagentStockDetailList.add(reagentStockDetail);
                                }
                            });
                            stockDetailDao.insertStockDetail(reagentStockDetailList);
                        }
                    });
                });
                stockDao.insertStock(reagentStockList);
            }
*/
            /* //第一层出库插入
            ReagentOutBill outBill = new ReagentOutBill();
            outBill.setBillType(billType);
            outBill.setBillDate(new Date());
            //outBill.setBillStatus(tinyint(1));
            outBill.setApplicationUser(refund.getCreateBy());
            outBill.setBillCreator(refund.getCreateBy());
            outBill.setRemark(refund.getRemark());
            outBill.setBranchName(branch);
            outBill.setApplicationDate(new Date());

            int random2 = new Random().nextInt(100);
            Long time2 = new Date().getTime();
            String billCode = String.valueOf(random2) + String.valueOf(time2);
            outBill.setBillCode(billCode);
            outBillMapper.insert(outBill);

            //出库二层
            List<ReagentOutDetail> reagentOutDetailList = new ArrayList<>();
            refundMessList.forEach(refundMessItem -> {
                stockList.forEach(stockDetailInfoItem -> {
                    if (refundMessItem.getStockNo().equals(stockDetailInfoItem.getStockNo())) {
                        int random3 = new Random().nextInt(100);
                        Long temp = new Date().getTime();
                        String outDetailId = random3 + String.valueOf(temp);

                        ReagentOutDetail outDetail = new ReagentOutDetail();
                        outDetail.setBillCode(billCode);
                        outDetail.setOutDetailId(outDetailId);
                        outDetail.setReagentId(stockDetailInfoItem.getReagentId());
                        outDetail.setReagentName(stockDetailInfoItem.getReagentName());

                        //根据库存编号将库存与库存详细对应，以查找试剂的批号和注册证号
                        stockDetailInfoList.forEach(stockDetailItem -> {
                            if (stockDetailInfoItem.getStockNo().equals(stockDetailItem.getStockNo())) {
                                outDetail.setReagentSpecification(stockDetailItem.getSpecification());
                                outDetail.setBatchNo(stockDetailItem.getBatchNo());
                                outDetail.setFactory(stockDetailItem.getManufacturerName());
                                outDetail.setRegistrationNo(stockDetailItem.getRegistrationNo());
                                outDetail.setSupplierShortName(stockDetailItem.getSupplierShortName());
                            }
                        });
                        outDetail.setReagentUnit(stockDetailInfoItem.getReagentUnit());
                        outDetail.setQuantity(refundMessItem.getQuantity().longValue());
                        outDetail.setCreateTime(new Date());
                        outDetail.setCreateBy(refund.getCreateBy());
                        reagentOutDetailList.add(outDetail);

                        // 出库第三层
                        List<ReagentOutDetailItem> outDetailItemList = new ArrayList<>();

                        stockDetailInfoList.forEach(stockDetailItem -> {
                            if (stockDetailInfoItem.getStockNo().equals(stockDetailItem.getStockNo())) {
                                ReagentOutDetailItem outDetailItem = new ReagentOutDetailItem();
                                outDetailItem.setBillCode(billCode);
                                outDetailItem.setOutDetailId(outDetailId);
                                outDetailItem.setCreateTime(new Date());
                                outDetailItem.setReagentCode(stockDetailItem.getReagentCode());
                                outDetailItem.setQrCode(stockDetailItem.getQrCode());
                                outDetailItem.setCodeValue(stockDetailItem.getCodeValue());
                                outDetailItem.setCreateBy(refund.getCreateBy());
                                outDetailItem.setStatus(stockDetailInfoItem.getReagentStatus());
                                outDetailItemList.add(outDetailItem);
                            }
                        });
                        outItemDao.insertItem(outDetailItemList);
                    }
                });
            });
            outDetailDao.insertOutDetail(reagentOutDetailList);
            */
            return 1;

        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }

    @Override
    public int createBill(ReagentStockReqPost req) {

        Date timeNow = new Date();

        // 根据用户名判断用户角色
        // 试剂操作员删除领用人姓名，科室库管删除科室名，中心库管更改状态为退货
        try {
            Long adminId = adminDao.selectByUser(req.getCreateBy());
            Long roleId = adminRoleDao.selectByAdmin(adminId);
            String branch = adminDao.selectBranch(req.getCreateBy());
            List<String> qrList = req.getQrList();

            if (roleId == 4 || roleId == 9) {
                //中心和科室试剂操作员
                stockDetailDao.updateApplyMan(null, qrList);
                stockDetailDao.updateFetchStatus("1998", qrList, null);
            } else if (roleId == 3) {
                //科室库管
                String centre = "中心库";
                stockDetailDao.updateFetchBranch(centre, qrList);
            } else if (roleId == 2 || roleId == 6) {
                //中心库管
                String reagentStatus = "5";
                stockDetailDao.updateFetchStatus(reagentStatus, qrList, null);

                //批量退货之后更新库存数量
                for (String refund : qrList) {
                    String stockNo = stockDetailDao.searchStockNo(refund);
                    Long quantity = stockDao.selectQuantity(stockNo);
                    stockDao.updateQBySN(stockNo, quantity.intValue() - 1);
                }
            }

            /**
             * 生成退货单
             * 试剂操作员不生成出库单
             */
            // roleID
            // 2-单级科室库管；3-两级科室库管；6-两级中心库管
            if (roleId == 2 || roleId == 3 || roleId == 6) {
                //String stockType = "1"; // 库存类型；1 一级库模式；3 二级库模式
                String refundType = "1";    // 退货类型：1，科室库-单级退货；2，中心退货；3，科室库-二级退货
                String outType = "1";    // 出库单种类：1.科室库-单级退货出库单, 2.科室库-两级退货出库,3.中心库退货出库
                /*String inType = ""; // ? 入库类型
                String refundStatus = "";  // ? 退货状态（详细表里）*/

                if (roleId == 3) {  // 二级科室管理,科室退货不需要生成出库单此处outType可以不用
                    refundType = "3";
                    //stockType = "3";
                    outType = "2";
                }
                if (roleId == 6) {  // 二级中心库管
                    refundType = "2";
                    outType = "3";
                    //stockType = "3";
                }

                List<ReagentItem> stockItemList = new ArrayList<>();
                for (String qrCode : qrList) {
                    ReagentItem ri = stockDetailDao.findReagentItem(qrCode);
                    stockItemList.add(ri);
                }

                List<ReagentRefundMess> refundMessList = new ArrayList<>();

                // start: 按同类型试剂分类，拼装 refundMessList
                for (ReagentItem ri : stockItemList) {
                    ReagentRefundMess obj = null;
                    for (ReagentRefundMess rm : refundMessList) {
                        if (rm.getStockNo().equals(ri.getBillId().toString())) obj = rm;
                    }
                    // messList 不存在该类型试剂
                    if (obj == null) {
                        ReagentRefundMess rm = new ReagentRefundMess();
                        rm.setReagentId(ri.getReagentId().toString());
                        rm.setQuantity(1);
                        rm.setReagentPrice(ri.getReagentPrice());
                        rm.setStockNo(ri.getBillId().toString());
                        rm.setSupplierShortName(ri.getSupplierShortName());
                        rm.getQrList().add(ri.getQrCode());
                        rm.getQrCodeValueList().add(ri.getQrCodeValue());
                        rm.getReagentCodeList().add(ri.getReagentCode());

                        refundMessList.add(rm);
                    } else {
                        obj.getQrList().add(ri.getQrCode());
                        obj.getQrCodeValueList().add(ri.getQrCodeValue());
                        obj.getReagentCodeList().add(ri.getReagentCode());
                        obj.setQuantity(obj.getQuantity() + 1);
                    }

                }
                // end: 按同类型试剂分类，拼装 refundMessList

                List<String> stockInfos = new ArrayList<>();
                refundMessList.forEach(item -> {
                    stockInfos.add(item.getStockNo());
                });

                ReagentStockExample stockInfoExample = new ReagentStockExample();
                ReagentStockExample.Criteria criteria = stockInfoExample.createCriteria();
                criteria.andStockNoIn(stockInfos);

                // 存储所有申请单详细信息，面向中心库
                List<ReagentStock> stockList = stockInfoMapper.selectByExample(stockInfoExample);

                // 按供应商ID分组
                Map<String, List<ReagentPreRefund>> stockInfoList = new HashMap<>();
                refundMessList.forEach(item -> {
                    // 判断新增加的药剂是否已经有对应的供应商订单
                    if (stockInfoList.containsKey(item.getSupplierShortName())) {
                        stockList.forEach(stockInfoItem -> {
                            if (stockInfoItem.getStockNo().equals(item.getStockNo())) {
                                ReagentPreRefund reagentPreRefund = new ReagentPreRefund();
                                reagentPreRefund.setInfo(stockInfoItem);
                                reagentPreRefund.setInfoNumber(item.getQuantity());
                                stockInfoList.get(item.getSupplierShortName()).add(reagentPreRefund);
                            }
                        });
                    } else {    // 如果没有，创建一条新的订单信息,里面包含订单详细和数量
                        stockList.forEach(stockInfoItem -> {
                            if (stockInfoItem.getStockNo().equals(item.getStockNo())) {
                                ReagentPreRefund reagentPreRefund = new ReagentPreRefund();
                                reagentPreRefund.setInfo(stockInfoItem);
                                reagentPreRefund.setInfoNumber(item.getQuantity());
                                List<ReagentPreRefund> list = new ArrayList<>();
                                list.add(reagentPreRefund);
                                stockInfoList.put(item.getSupplierShortName(), list);
                            }
                        });
                    }
                });

                // 库存第二层数据查询
                ReagentStockDetailExample stockDetailExample = new ReagentStockDetailExample();
                ReagentStockDetailExample.Criteria detailCriteria = stockDetailExample.createCriteria();
                detailCriteria.andStockNoIn(stockInfos);

                List<ReagentStockDetail> stockDetailListAll = stockDetailMapper.selectByExample(stockDetailExample);

                List<ReagentStockDetail> stockDetailInfoList = new ArrayList<>();
                refundMessList.forEach(refundMessItem -> {
                    AtomicInteger item = new AtomicInteger(0);
                    stockDetailListAll.forEach(stockDetailItem -> {
                        int i = item.get();
                        if (stockDetailItem.getStockNo().equals(refundMessItem.getStockNo())) {
                            if (i < refundMessItem.getQuantity()) {
                                stockDetailInfoList.add(stockDetailItem);
                                item.incrementAndGet();
                            }
                        }
                    });
                });

                try {
                    String finalRefundType = refundType;
                    String finalOutType = outType;
                    Date OutTimeNow = new Date();
                    stockInfoList.forEach((item, messList) -> {
                        // 退货单对象
                        ReagentRefund refundItem = new ReagentRefund();
                        refundItem.setCreateTime(new Date());
                        refundItem.setRefundType(finalRefundType);
                        refundItem.setRemark(req.getRemark());
                        refundItem.setCreateBy(req.getCreateBy());
                        refundItem.setSupplierShortName(messList.get(0).getInfo().getSupplierName());
                        refundItem.setBranch(branch);
                        double totalPrice = messList.stream().mapToDouble(priceItem -> priceItem.getInfoNumber().longValue() * priceItem.getInfo().getReagentPrice()).sum();
                        double quantity = messList.stream().mapToDouble(priceItem -> priceItem.getInfoNumber().longValue()).sum();

                        refundItem.setQuantity((long) quantity);
                        refundItem.setTotal(totalPrice);

                        Long time1 = new Date().getTime();
                        Random ne2 = new Random();//实例化一个random的对象ne
                        int x2 = ne2.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                        String random_order2 = String.valueOf(x2);
                        String refundCode = time1 + random_order2;
                        refundItem.setRefundCode(refundCode);

                        int result = refundMapper.insert(refundItem);

                        //出库单第一层
                        ReagentOutBill outBill = new ReagentOutBill();

                        Long time2 = new Date().getTime();
                        Random ne3 = new Random();//实例化一个random的对象ne
                        int x3 = ne3.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                        String random_order3 = String.valueOf(x3);
                        String billCode = time2 + random_order3;

                        outBill.setBillCode(billCode);
                        outBill.setBillType(finalOutType);
                        outBill.setBillDate(new Date());
                        outBill.setBillStatus(BillStatus.real.getValue());
                        outBill.setBillCreator(req.getCreateBy());
                        outBill.setRemark(req.getRemark());
                        outBill.setBranchName(branch);
                        outBill.setUpdateTime(OutTimeNow);
                        outBill.setCreateTime(OutTimeNow);
                        outBill.setApplicationDate(OutTimeNow);
                        outBill.setApplicationUser(req.getCreateBy());
                        int billId = outBillMapper.insert(outBill);

                        // 写入退货单详细表 //出库单详细第二层
                        List<ReagentRefundDetail> reagentRefundDetailList = new ArrayList<>();
                        List<ReagentOutDetail> reagentOutDetailList = new ArrayList<>();
                        refundMessList.forEach(refundMessItem -> {
                            messList.forEach(stockInfoItem -> {
                                if (refundMessItem.getStockNo().equals(stockInfoItem.getInfo().getStockNo())) {
                                    Long time3 = new Date().getTime();
                                    Random ne4 = new Random();//实例化一个random的对象ne
                                    int x4 = ne4.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                                    String random_order4 = String.valueOf(x4);
                                    String detailId = time3 + random_order4;

                                    //start: outDetail单据生成开始
                                    ReagentOutDetail outDetail = new ReagentOutDetail();
                                    outDetail.setBillCode(billCode);
                                    outDetail.setOutDetailId(detailId);
                                    outDetail.setReagentId(stockInfoItem.getInfo().getReagentId());
                                    outDetail.setReagentName(stockInfoItem.getInfo().getReagentName());
                                    outDetail.setReagentSpecification(stockInfoItem.getInfo().getReagentType());
                                    outDetail.setFactory(stockInfoItem.getInfo().getFactory());
                                    outDetail.setSupplierShortName(stockInfoItem.getInfo().getSupplierName());
                                    outDetail.setReagentUnit(stockInfoItem.getInfo().getReagentUnit());
                                    outDetail.setPrice(refundMessItem.getReagentPrice());
                                    outDetail.setQuantity(refundMessItem.getQuantity().longValue());
                                    double reagentTotal = refundMessItem.getReagentPrice() * refundMessItem.getQuantity();
                                    outDetail.setTotal(reagentTotal);
                                    outDetail.setExpireDate(new Date());
                                    outDetail.setCreateTime(OutTimeNow);
                                    outDetail.setCreateBy(req.getCreateBy());
                                    outDetail.setApplicationUser(req.getCreateBy());
                                    outDetail.setUpdateTime(OutTimeNow);
                                    outDetail.setUpdateBy(req.getCreateBy());

                                    //end: outDetail单据生成结束

                                    //start: refundDetail单据生成开始
                                    ReagentRefundDetail refundDetail = new ReagentRefundDetail();
                                    refundDetail.setRefundCode(refundCode);
                                    refundDetail.setRefundDetailId(detailId);
                                    refundDetail.setReagentId(stockInfoItem.getInfo().getReagentId());
                                    refundDetail.setReagentName(stockInfoItem.getInfo().getReagentName());
                                    refundDetail.setReagentSpecification(stockInfoItem.getInfo().getReagentType());

                                    // 根据库存编号将库存与库存详细对应，以查找试剂的批号和注册证号
                                    stockDetailInfoList.forEach(stockDetailItem -> {
                                        if (stockInfoItem.getInfo().getStockNo().equals(stockDetailItem.getStockNo())) {
                                            refundDetail.setBatchNo(stockDetailItem.getBatchNo());
                                            refundDetail.setRegistrationNo(stockDetailItem.getRegistrationNo());
                                            outDetail.setBatchNo(stockDetailItem.getBatchNo());
                                            outDetail.setRegistrationNo(stockDetailItem.getRegistrationNo());
                                        }
                                    });

                                    refundDetail.setFactory(stockInfoItem.getInfo().getFactory());
                                    refundDetail.setSupplierShortName(stockInfoItem.getInfo().getSupplierName());
                                    refundDetail.setReagentUnit(stockInfoItem.getInfo().getReagentUnit());
                                    refundDetail.setReagentPrice(refundMessItem.getReagentPrice());
                                    refundDetail.setQuantity(refundMessItem.getQuantity().longValue());
                                    refundDetail.setTotal(reagentTotal);
                                    refundDetail.setCreateTime(new Date());
                                    refundDetail.setCreateBy(req.getCreateBy());
                                    reagentRefundDetailList.add(refundDetail);
                                    reagentOutDetailList.add(outDetail);

                                    // start: 出库单、退货单第三层
                                    List<ReagentOutDetailItem> outItems = new ArrayList<>();
                                    List<ReagentRefundItem> refundItems = new ArrayList<>();
                                    for (int i = 0; i < refundMessItem.getQuantity(); i++) {

                                        ReagentOutDetailItem itemOut = new ReagentOutDetailItem();
                                        itemOut.setBillCode(billCode);
                                        itemOut.setOutDetailId(detailId);
                                        itemOut.setCreateTime(timeNow);
                                        itemOut.setCreateBy(req.getCreateBy());
                                        itemOut.setReagentCode(refundMessItem.getReagentCodeList().get(i));
                                        itemOut.setQrCode(refundMessItem.getQrList().get(i));
                                        itemOut.setCodeValue(refundMessItem.getQrCodeValueList().get(i));
                                        outItems.add(itemOut);

                                        ReagentRefundItem itemRefund = new ReagentRefundItem();
                                        itemRefund.setRefundCode(refundCode);
                                        itemRefund.setRefundDetailId(detailId);
                                        itemRefund.setCreateTime(timeNow);
                                        itemRefund.setCreateBy(req.getCreateBy());
                                        itemRefund.setReagentCode(refundMessItem.getReagentCodeList().get(i));
                                        itemRefund.setQrCode(refundMessItem.getQrList().get(i));
                                        itemRefund.setCodeValue(refundMessItem.getQrCodeValueList().get(i));
                                        refundItems.add(itemRefund);
                                    }
                                    // end: 出库单、退货单第三层

                                    outItemDao.insertItem(outItems);
                                    refundDetailItemDao.insertItem(refundItems);
                                }
                            });
                        });

                        outDetailDao.insertOutDetail(reagentOutDetailList);
                        refundDetailDao.insertRefundDetail(reagentRefundDetailList);
                        //end: refundDetail单据生成结束
                    });
                    return 1;
                } catch (Exception e) {
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    @Override
    public List<ReagentRefund> getAllByRefundType(String refundType) {
        return refundDao.getAllByRefundType(refundType);
    }

    /**
     * 修改领用信息
     *
     * @param id
     * @param refund
     */
    @Override
    public int update(Long id, ReagentRefund refund) {
        refund.setId(id);
        return refundMapper.updateByPrimaryKeySelective(refund);
    }

    /**
     * 批量删除领用
     *
     * @param ids
     */

    @Override
    public int delete(List<Long> ids) {
        ReagentRefundExample example = new ReagentRefundExample();
        example.createCriteria().andIdIn(ids);
        return refundMapper.deleteByExample(example);
    }

    /**
     * 分页获取领用列表
     *
     * @param refundType
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentRefund> list(String refundType, String keyword, String username, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);
        String supplier = adminDao.selectSupplier(username);

        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        if (roleId == 1 || roleId == 6) branch = null;

        List<ReagentRefund> refundList;
        PageHelper.startPage(pageNum, pageSize);
        refundList = refundDao.selectByBranch(refundType, keyword, branch, supplier);

        return refundList;
    }

    @Override
    public List<ReagentRefundDetail> countRefund(String refundType, String username, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return refundDao.countRefund(refundType);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ReagentRefund getItem(Long id) {
        return refundMapper.selectByPrimaryKey(id);
    }

    /**
     * @param refundCode
     * @return
     */
    public int deleteByRefundCode(String refundCode) {
        ReagentRefundExample example = new ReagentRefundExample();
        example.createCriteria().andRefundCodeEqualTo(refundCode);
        return refundMapper.deleteByExample(example);
    }

}