package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.ReagentEditBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentEditBillPost;
import jp.co.nss.hrm.backend.api.dto.ReagentInBillDetail;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.api.service.ReagentInBillDetailService;
import jp.co.nss.hrm.backend.mapper.*;
import jp.co.nss.hrm.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReagentInDetailServiceImpl implements ReagentInBillDetailService {

    @Autowired
    private ReagentInBillMapper inBillMapper;

    @Autowired
    private ReagentInDetailMapper inBillDetailMapper;

    @Autowired
    private ReagentInDetailItemMapper inBillDetailItemMapper;

    @Autowired
    private ReagentInBillDao inBillDao;

    @Autowired
    private ReagentInDetailDao inDetailDao;

    @Autowired
    private ReagentInDetailItemDao inDetailItemDao;

    @Autowired
    private ReagentStockDao stockDao;

    @Autowired
    private ReagentStockMapper stockMapper;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentPreInBillDao preInBillDao;

    @Autowired
    private ReagentPreInDetailItemDao preInItemDao;

    @Autowired
    private ReagentBaseInfoDao baseInfoDao;

    @Autowired
    private ReagentBaseInfoMapper baseInfoMapper;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentOrderDao orderDao;





    /**
     * 试剂出库报表
     */
    @Override
    public PageInfo<ReagentInBillDetail> inSummary(String username, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);

        List<ReagentInBillDetail> inSummaryList = inDetailDao.inSummary(branch, reagentName, startTime, endTime);
        //创建Page类
        Page<ReagentInBillDetail> page = new Page<>(pageNum, pageSize);
        int total;
        //为Page类中的total属性赋值
        total = inSummaryList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        if (startIndex > endIndex) startIndex = 0;
        page.addAll(inSummaryList.subList(startIndex, endIndex));

        //以Page创建PageInfo
        return new PageInfo<>(page);
    }
    /**
     * 根据入库单号获取入库单详细信息
     *
     * @param billCode
     */
    @Override
    public List<ReagentInBillDetail> getInBillDetail(String billCode) {

        return inDetailDao.selectByBillCode(billCode);
    }

    /**
     * 修改订单详细信息
     *
     * @param inDetail
     */
    @Override
    public int update(ReagentInDetail inDetail) {
        //更新总价格
        Double price = inDetail.getPrice();
        Long quantity = inDetail.getQuantity();
        double total = price * quantity;
        inDetail.setTotal(total);

        return inBillDetailMapper.updateByPrimaryKeySelective(inDetail);
    }

    @Override
    public int delete(List<String> billCodes) {
        ReagentInDetailExample example = new ReagentInDetailExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = inBillDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 删除指定订单详情
     */
    @Override
    public int delete(Long id) {
        int count = inBillDetailMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<ReagentInBillDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return inDetailDao.selectByBillCode(keyword);
    }

    /**
     * 编辑之后重新生成第三层信息
     */
    @Override
    public int editInBill(ReagentEditBillPost editBill) {
        String status = editBill.getStatus();
        List<ReagentEditBillMess> editBillMessList = editBill.getEditBillMessList();
        //先删除原有的信息
        ReagentInDetailItemExample example = new ReagentInDetailItemExample();
        example.createCriteria().andBillCodeEqualTo(editBill.getBillCode());
        inBillDetailItemMapper.deleteByExample(example);

        //更新入库单更新时间
        ReagentInBill inBill = new ReagentInBill();
        inBill.setUpdateTime(new Date());

        String inDetailId = editBillMessList.get(0).getInDetailId();
        ReagentInDetailExample inDetailExample = new ReagentInDetailExample();
        inDetailExample.createCriteria().andInDetailIdEqualTo(inDetailId);
        List<ReagentInDetail> inDetailList = inBillDetailMapper.selectByExample(inDetailExample);

        String billCode = inDetailList.get(0).getBillCode();
        ReagentInBillExample inBillExample = new ReagentInBillExample();
        inBillExample.createCriteria().andBillCodeEqualTo(billCode);
        inBillMapper.updateByExampleSelective(inBill, inBillExample);


        for (ReagentEditBillMess editItem : editBillMessList) {
            // 写入入库单详情表
            List<ReagentInDetailItem> inDetailItemList = new ArrayList<>();


            String reagentName = editItem.getReagentName();
            String reagentId = baseInfoDao.getReagentId(reagentName);
            String batchNo = editItem.getBatchNo();
            int batchCount = Integer.parseInt(stockDetailDao.countBatchNo(reagentId, batchNo));

            //格式化日期，添加到二维码中
            Date expireDate = editItem.getExpireDate();
            String expireDateFormat = String.format("%tY", expireDate) + "-" +
                    String.format("%tm", expireDate) + "-" +
                    String.format("%td", expireDate);

            //获取供货商名，添加到二维码中
            String supplierShortName;
            supplierShortName = inBillDao.selectSupplier(editBill.getBillCode());

            for (int i = batchCount + 1; i <= batchCount + editItem.getQuantity(); i++) {
                ReagentInDetailItem inDetailItem = new ReagentInDetailItem();

                inDetailItem.setBillCode(editBill.getBillCode());
                inDetailItem.setCreateTime(new Date());
                inDetailItem.setInDetailId(editItem.getInDetailId());
                String sort;
                if (editItem.getQuantity() < 1000) {
                    if (i < 10) {
                        sort = "00" + i;
                    } else if (i < 100) {
                        sort = "0" + i;
                    } else {
                        sort = Integer.toString(i);
                    }
                } else if (editItem.getQuantity() < 10000) {
                    if (i < 10) {
                        sort = "000" + i;
                    } else if (i < 100) {
                        sort = "00" + i;
                    } else if (i < 1000) {
                        sort = "0" + i;
                    } else {
                        sort = Integer.toString(i);
                    }
                } else {
                    if (i < 10) {
                        sort = "0000" + i;
                    } else if (i < 100) {
                        sort = "000" + i;
                    } else if (i < 1000) {
                        sort = "00" + i;
                    } else if (i < 10000) {
                        sort = "0" + i;
                    } else {
                        sort = Integer.toString(i);
                    }
                }
                String reagentCode = editItem.getBatchNo() + sort;
                inDetailItem.setReagentCode(reagentCode);
                inDetailItem.setStatus(status);

                //生成二维码信息
                String codeValue = "名称: " + editItem.getReagentName() +
                        "<br/>厂家: " + editItem.getFactory() +
                        "<br/>供货商: " + supplierShortName +
                        "<br/>批号: " + editItem.getBatchNo() +
                        "<br/>有效期: " + expireDateFormat +
                        "<br/>编号: " + reagentCode;

                String qrCode = editItem.getInDetailId() + reagentCode;
                inDetailItem.setCodeValue(codeValue);
                inDetailItem.setQrCode(qrCode);

                inDetailItemList.add(inDetailItem);
            }
            inDetailItemDao.insertBillItem(inDetailItemList);
        }
        return 1;
    }

    /**
     * 提交入库信息
     */
    @Override
    public int subInBill(ReagentEditBillPost subBill) {
        String billStatus = subBill.getStatus();
        String billCode = subBill.getBillCode();
        List<ReagentEditBillMess> subBillMessList = subBill.getSubBillMessList();

        //存储详细ID
        List<String> inDetailIds = new ArrayList<>();
        subBillMessList.forEach(item -> inDetailIds.add(item.getInDetailId()));

        //获取入库单第一层信息
        ReagentInBillExample inBillExample = new ReagentInBillExample();
        inBillExample.createCriteria().andBillCodeEqualTo(billCode);
        List<ReagentInBill> inBill = inBillMapper.selectByExample(inBillExample);

        //获取入库单第二层信息
        ReagentInDetailExample inDetailExample = new ReagentInDetailExample();
        inDetailExample.createCriteria().andInDetailIdIn(inDetailIds);
        List<ReagentInDetail> inBillDetail = inBillDetailMapper.selectByExample(inDetailExample);

        //获取入库单第三层信息
        ReagentInDetailItemExample inDetailItemExample = new ReagentInDetailItemExample();
        inDetailItemExample.createCriteria().andBillCodeEqualTo(billCode);
        List<ReagentInDetailItem> inDetailItem = inBillDetailItemMapper.selectByExample(inDetailItemExample);

        String stockType = null;
        if (inBill.get(0).getCreateType().equals("1") || inBill.get(0).getCreateType().equals("3")) {
            //一级建码扫码入库
            stockType = "1";
        } else if (inBill.get(0).getCreateType().equals("2") || inBill.get(0).getCreateType().equals("4")) {
            //二级建码扫码入库
            stockType = "3";
        }

        try {
            //写入库存 reagentStock
            //获取下单人对应的科室（单级库-科室名，两级库-中心库）
            String branch = adminDao.selectBranch(inBill.get(0).getBillCreator());
            String finalStockType = stockType;
            subBillMessList.forEach(subInBill -> {
                inBillDetail.forEach(inDetail -> {
                    if (subInBill.getInDetailId().equals(inDetail.getInDetailId())) {
                        //第一层
                        ReagentStock reagentStock = new ReagentStock();
                        // 存储申请单中试剂详细信息,根据试剂名称，供货商ID，生产厂家进行查找
                        /*List<ReagentBaseInfo> baseInfoList = baseInfoDao.getInfoList(
                                inDetail.getReagentName(), inBill.get(0).getSupplierId(), inDetail.getFactory());*/
                        ReagentBaseInfoExample baseInfoExample = new ReagentBaseInfoExample();
                        baseInfoExample.createCriteria().andCodeEqualTo(inDetail.getReagentId());
                        List<ReagentBaseInfo> baseInfoList = baseInfoMapper.selectByExample(baseInfoExample);

                        String stockNo;

                        //获取库存中现有试剂的ID
                        List<ReagentStock> stockListAll = stockMapper.selectByExample(new ReagentStockExample());
                        List<String> codeInfos = new ArrayList<>();
                        stockListAll.forEach(stockItem -> codeInfos.add(stockItem.getReagentId()));

                        //如果库存中有该试剂信息,只更新汇总表数量
                        if (codeInfos.contains(inDetail.getReagentId())) {
                            ReagentStockExample example = new ReagentStockExample();
                            example.createCriteria().andReagentIdEqualTo(inDetail.getReagentId());
                            List<ReagentStock> stockNoList = stockMapper.selectByExample(example);
                            Integer Quantity = Math.toIntExact(stockNoList.get(0).getQuantity() + inDetail.getQuantity());
                            stockNo = stockNoList.get(0).getStockNo();
                            stockDao.updateQBySN(stockNo, Quantity);
                        } else {
                            Long time1 = new Date().getTime();
                            Random ne2 = new Random();//实例化一个random的对象ne
                            int x2 = ne2.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                            String random_order2 = String.valueOf(x2);
                            stockNo = time1 + random_order2;

                            reagentStock.setStockNo(stockNo);

                            for (ReagentBaseInfo baseInfo : baseInfoList) {
                                //试剂名称和生产厂家均相同
                                if (inDetail.getReagentName().equals(baseInfo.getName()) && inDetail.getFactory().equals(baseInfo.getManufacturerName())) {
                                    reagentStock.setReagentId(baseInfo.getCode());
                                    reagentStock.setReagentTemp(baseInfo.getStockType());
                                    reagentStock.setLowStock(baseInfo.getStockLimit().toString());
                                    reagentStock.setOverdue(baseInfo.getExpirationLimit());
                                }
                            }
                            reagentStock.setStockType(finalStockType);
                            reagentStock.setReagentName(inDetail.getReagentName());
                            reagentStock.setReagentType(inDetail.getReagentSpecification());
                            reagentStock.setReagentUnit(inDetail.getReagentUnit());
                            reagentStock.setFactory(inDetail.getFactory());
                            reagentStock.setSupplierName(inBill.get(0).getSupplierShortName());
                            reagentStock.setBranchName(branch);
                            reagentStock.setQuantity(inDetail.getQuantity());
                            reagentStock.setReagentPrice(inDetail.getPrice());
                            reagentStock.setReagentStatus(billStatus);

                            stockMapper.insert(reagentStock);
                        }

                        //第二层
                        List<ReagentStockDetail> reagentStockDetailList = new ArrayList<>();

                        inDetailItem.forEach(item -> {
                            ReagentStockDetail reagentStockDetail = new ReagentStockDetail();
                            if (inDetail.getInDetailId().equals(item.getInDetailId())) {
                                reagentStockDetail.setStockNo(stockNo);
                                reagentStockDetail.setStockType(finalStockType);

                                for (ReagentBaseInfo baseInfo : baseInfoList) {
                                    //试剂名称和生产厂家均相同
                                    if (inDetail.getReagentName().equals(baseInfo.getName()) && inDetail.getFactory().equals(baseInfo.getManufacturerName())) {
                                        reagentStockDetail.setReagentId(baseInfo.getCode());
                                        reagentStockDetail.setRegistrationNo(baseInfo.getRegistrationNo());
                                        reagentStockDetail.setReagentTemp(baseInfo.getStockType());
                                        reagentStockDetail.setOpenPeriod(baseInfo.getUseDayLimit());
                                        reagentStockDetail.setOverdue(baseInfo.getExpirationLimit());
                                    }
                                }

                                reagentStockDetail.setReagentName(inDetail.getReagentName());
                                reagentStockDetail.setSpecification(inDetail.getReagentSpecification());
                                reagentStockDetail.setManufacturerName(inDetail.getFactory());
                                reagentStockDetail.setSupplierShortName(inBill.get(0).getSupplierShortName());
                                reagentStockDetail.setBranch(branch);

                                reagentStockDetail.setReagentUnit(inDetail.getReagentUnit());
                                reagentStockDetail.setReagentStatus("1998");
                                reagentStockDetail.setReagentCode(item.getReagentCode());
                                reagentStockDetail.setQrCode(item.getQrCode());

                                reagentStockDetail.setCodeValue(item.getCodeValue());
                                reagentStockDetail.setBatchNo(inDetail.getBatchNo());
                                reagentStockDetail.setExpireDate(inDetail.getExpireDate());
                                if (inDetail.getExpireDate() != null) {
                                    Date d1 = inDetail.getExpireDate();
                                    Date d2 = new Date();
                                    long daysBetween = d1.getTime() - d2.getTime();
                                    long diffDate = daysBetween / 86400000;
                                    int daysDiff;
                                    if (daysBetween < 0) {
                                        daysDiff = (int) diffDate;
                                    } else {
                                        daysDiff = (int) (diffDate + 1);
                                    }
                                    reagentStockDetail.setRemainDay(daysDiff);
                                }
                                reagentStockDetail.setReagentPrice(inDetail.getPrice());

                                reagentStockDetail.setEnterTime(new Date());
                                reagentStockDetail.setEnterNo(billCode);
                                reagentStockDetail.setEnterMan(inBill.get(0).getBillCreator());
                                reagentStockDetail.setUpdateTime(new Date());

                                reagentStockDetailList.add(reagentStockDetail);
                            }
                        });
                        stockDetailDao.insertStockDetail(reagentStockDetailList);
                    }
                });
            });

            //更新入库单更新时间
            inBill.get(0).setUpdateTime(new Date());
            ReagentInBillExample inBillExample1 = new ReagentInBillExample();
            inBillExample1.createCriteria().andBillCodeEqualTo(inBill.get(0).getBillCode());
            inBillMapper.updateByExampleSelective(inBill.get(0), inBillExample1);

            //更新预入库单状态
            //获取一个二维码，查找对应的预入库单编号，以便更新预入库单状态
            String qrCodeIndex;
            String preBillCode = null;
            qrCodeIndex = inDetailItem.get(0).getQrCode();
            if (qrCodeIndex != null) {
                preBillCode = preInItemDao.getPreCode(qrCodeIndex);
            }
            //更新订单状态为已完成
            if (preBillCode != null) {
                preInBillDao.updateStatus(preBillCode, billStatus);
                preInItemDao.updateStatus(preBillCode, billStatus);

                String orderStatus = "4";
                orderDao.updateByON(preBillCode, orderStatus);
            }
            //计算过期预警时间差
            List<ReagentStock> stockListAll = stockDao.selectByBranch(stockType, null, null, null, null, branch);
            for (ReagentStock item : stockListAll) {
                Date d1 = stockDetailDao.findMinDate(item.getStockNo(), branch);
                Date d2 = new Date();
                if (d1 != null) {
                    long daysBetween = d1.getTime() - d2.getTime();
                    //111如果小于0，如果222=1或者=0
                    long diffDate = (daysBetween / (60 * 60 * 24 * 1000));
                    int daysDiff;
                    if (daysBetween < 0) {
                        daysDiff = (int) diffDate;
                    } else {
                        daysDiff = (int) (diffDate + 1);
                    }
                    stockDao.updateOverdueStock(item.getStockNo(), daysDiff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    /**
     * 编辑状态分页获取详细信息列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentInfo> listInBill(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return inDetailDao.selectByBillCode2(keyword);
    }
}


