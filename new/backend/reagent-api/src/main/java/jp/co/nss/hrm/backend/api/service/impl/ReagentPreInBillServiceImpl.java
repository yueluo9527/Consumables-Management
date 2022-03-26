package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillPost;
import jp.co.nss.hrm.backend.api.service.ReagentPreInBillService;
import jp.co.nss.hrm.backend.mapper.*;
import jp.co.nss.hrm.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReagentPreInBillServiceImpl implements ReagentPreInBillService {

    @Autowired
    private ReagentPreInBillMapper preInBillMapper;

    @Autowired
    private ReagentPreInDetailMapper preInDetailMapper;

    @Autowired
    private ReagentBaseInfoMapper baseInfoMapper;

    @Autowired
    private ReagentSupplierMapper supplierMapper;

    @Autowired
    private ReagentPreInDetailDao preInDetailDao;

    @Autowired
    private ReagentPreInDetailItemDao preInDetailItemDao;

    @Autowired
    private ReagentPreInBillDao preInBillDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    @Autowired
    private ReagentOrderDao orderDao;

    @Autowired
    private ReagentOrderDetailMapper orderDetailMapper;

    @Autowired
    private ReagentInBillDao inBillDao;

    @Autowired
    private ReagentOutBillDao outBillDao;

    @Autowired
    private ReagentOrderDetailDao orderDetailDao;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentCollectDao collectDao;

    @Autowired
    private ReagentRefundDao refundDao;

    /**
     * 获取所有预入库单列表
     */
    @Override
    public List<ReagentPreInBill> list() {

        return preInBillMapper.selectByExample(new ReagentPreInBillExample());
    }

    /**
     * 添加预入库单
     *
     * @param preInBill
     */

    @Override
    public int create(ReagentPreInBillPost preInBill) {
        String billStatus = preInBill.getBillStatus();
        String billType = preInBill.getBillType();
        String orderNo = preInBill.getOrderNo();
        List<ReagentPreInBillMess> preInBillMessList = preInBill.getPreInBillMessList();
        List<String> baseInfos = new ArrayList<>();

        preInBillMessList.forEach(item -> {
            baseInfos.add(item.getCode());
        });

        // 获取数据库中订单中所有药品详情
        ReagentBaseInfoExample baseInfoExample = new ReagentBaseInfoExample();
        ReagentBaseInfoExample.Criteria criteria = baseInfoExample.createCriteria();
        criteria.andCodeIn(baseInfos);
        // 存储所有订单详细信息
        List<ReagentBaseInfo> baseInfoDetailList = baseInfoMapper.selectByExample(baseInfoExample);

        //根据orderNo去随货单中查找是否有此随货单，如果没有，则属于第一次创建随货单。如果有，则说明第一次发货没有全部发完，
        //需要第二次补发，此时不创建随货单第一层，只创建第二三层
        List<ReagentPreInDetail> judgePreDetail;
        ReagentPreInDetailExample preInDetailExample = new ReagentPreInDetailExample();
        preInDetailExample.createCriteria().andBillCodeEqualTo(orderNo);
        judgePreDetail = preInDetailMapper.selectByExample(preInDetailExample);
        int isPreDone = 0;
        AtomicInteger isPreDetailDone = new AtomicInteger();
        try {
            // 预入库单对象
            ReagentPreInBill preInBillItem = new ReagentPreInBill();
            if (judgePreDetail.isEmpty()) {
                //获得供应商ID
                String supplierID;
                ReagentSupplierExample supplierExample = new ReagentSupplierExample();
                ReagentSupplierExample.Criteria criteria1 = supplierExample.createCriteria();
                criteria1.andSupplierShortNameEqualTo(preInBillMessList.get(0).getSupplierShortName());
                List<ReagentSupplier> supplierList = supplierMapper.selectByExample(supplierExample);
                supplierID = supplierList.get(0).getSupplierCode();

                preInBillItem.setSupplierId(supplierID);
                preInBillItem.setSupplierShortName(preInBillMessList.get(0).getSupplierShortName());
                preInBillItem.setBillDate(new Date());
                preInBillItem.setBillType(billType);
                preInBillItem.setRemark(preInBill.getRemark());
                preInBillItem.setBillCreator(preInBill.getBillCreator());

                preInBillItem.setBillCode(orderNo);
                preInBillItem.setCreateTime(new Date());
                preInBillItem.setBillStatus("2");
                isPreDone = preInBillMapper.insert(preInBillItem);
            } else {
                //再次追加配货，更新随货单状态为未入库
                String status = "2";
                preInBillDao.updateStatus(orderNo, status);
            }

            // 写入预入库单详情表
            List<ReagentPreInDetail> reagentPreInDetailList = new ArrayList<>();
            preInBillMessList.forEach(preBillItem -> {
                baseInfoDetailList.forEach(baseInfoItem -> {
                    if (preBillItem.getCode().equals(baseInfoItem.getCode())) {
                        //生成预入库单详情表ID
                        Long time1 = new Date().getTime();
                        Random ne2 = new Random();//实例化一个random的对象ne
                        int x2 = ne2.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                        String random_order2 = String.valueOf(x2);
                        String inDetailId = time1 + random_order2;

                        ReagentPreInDetail preInDetail = new ReagentPreInDetail();
                        preInDetail.setBillCode(orderNo);
                        preInDetail.setReagentUnit(baseInfoItem.getUnit());
                        preInDetail.setInDetailId(inDetailId);
                        preInDetail.setReagentCode(baseInfoItem.getCode());
                        preInDetail.setReagentName(baseInfoItem.getName());
                        preInDetail.setReagentSpecification(baseInfoItem.getSpecification());
                        preInDetail.setFactory(preBillItem.getFactory());
                        preInDetail.setQuantity(preBillItem.getQuantity().longValue());

                        double totalPrice = preBillItem.getPrice() * preBillItem.getQuantity();
                        preInDetail.setTotal(totalPrice);
                        preInDetail.setPrice(preBillItem.getPrice());
                        preInDetail.setBatchNo(preBillItem.getBatchNo());
                        preInDetail.setExpireDate(preBillItem.getExpireDate());
                        preInDetail.setBillStatus(billStatus);
                        preInDetail.setRemark(preInBill.getRemark());
                        preInDetail.setCreateTime(new Date());
                        isPreDetailDone.set(preInDetailMapper.insert(preInDetail));
                        //reagentPreInDetailList.add(preInDetail);

                        // 写入预入库单详情表
                        List<ReagentPreInDetailItem> reagentPreInDetailItemList = new ArrayList<>();

                        //格式化日期，添加到二维码中
                        Date expireDate = preBillItem.getExpireDate();
                        String expireDateFormat = String.format("%tY", expireDate) + "-" +
                                String.format("%tm", expireDate) + "-" +
                                String.format("%td", expireDate);

                        String reagentId = baseInfoItem.getCode();
                        String batchNo = preBillItem.getBatchNo();

                        String stockCount = stockDetailDao.countBatchNo(reagentId, batchNo);
                        String preCount = preInDetailDao.countBatchNo(reagentId, batchNo);
                        int numCount;
                        if (stockCount == null) stockCount = "0";
                        if (preCount == null) preCount = "0";
                        numCount = Integer.parseInt(stockCount) + Integer.parseInt(preCount);

                        for (int i = numCount + 1; i <= numCount + preBillItem.getQuantity(); i++) {
                            ReagentPreInDetailItem reagentPreInDetailItem = new ReagentPreInDetailItem();
                            reagentPreInDetailItem.setBillCode(orderNo);
                            reagentPreInDetailItem.setCreateTime(new Date());
                            reagentPreInDetailItem.setInDetailId(inDetailId);
                            String sort;

                            if (preBillItem.getQuantity() < 1000) {
                                if (i < 10) {
                                    sort = "00" + i;
                                } else if (i < 100) {
                                    sort = "0" + i;
                                } else {
                                    sort = Integer.toString(i);
                                }
                            } else if (preBillItem.getQuantity() < 10000) {
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
                            String reagentCode = preBillItem.getBatchNo() + sort;
                            reagentPreInDetailItem.setReagentCode(reagentCode);
                            reagentPreInDetailItem.setCreateBy(preInBill.getBillCreator());
                            reagentPreInDetailItem.setStatus(billStatus);

                            //生成二维码信息
                            String codeValue = "名称: " + baseInfoItem.getName() +
                                    "<br/>厂家: " + preBillItem.getFactory() +
                                    "<br/>供货商: " + preBillItem.getSupplierShortName() +
                                    "<br/>批号: " + preBillItem.getBatchNo() +
                                    "<br/>有效期: " + expireDateFormat +
                                    "<br/>编号: " + reagentCode;

                            String qrCode = inDetailId + reagentCode;
                            reagentPreInDetailItem.setCodeValue(codeValue);
                            reagentPreInDetailItem.setQrCode(qrCode);

                            reagentPreInDetailItemList.add(reagentPreInDetailItem);
                        }
                        preInDetailItemDao.insertItem(reagentPreInDetailItemList);
                    }
                });
            });

            List<ReagentOrderDetail> orderDetailList = orderDetailDao.selectByOrderNo(orderNo);

            //更新订单中已发货数量和未发货数量
            preInBillMessList.forEach(preMessItem -> {
                orderDetailList.forEach(orderItem -> {
                    if (preMessItem.getCode().equals(orderItem.getReagentCode())) {

                        //已发货数量为原先发货数量加本次发货数量
                        orderItem.setSendNum(orderItem.getSendNum() + preMessItem.getQuantity());
                        //未发货数量等于订单数量减去已发货数量
                        long unSendNum = orderItem.getReagentNumber() - orderItem.getSendNum();
                        orderItem.setUnsendNum(unSendNum);

                        //更新
                        ReagentOrderDetailExample orderDetailExample = new ReagentOrderDetailExample();
                        orderDetailExample.createCriteria().andOrderNoEqualTo(orderNo).andReagentCodeEqualTo(orderItem.getReagentCode());
                        orderDetailMapper.updateByExampleSelective(orderItem, orderDetailExample);
                    }
                });
            });
            //是否名称和数量均对应上，对应上则表示已完成订单
            //遍历结束，未发货数量均为0，则订单完成
            AtomicBoolean isComplate = new AtomicBoolean(true);
            List<ReagentOrderDetail> judgeOrderList = orderDetailDao.selectByOrderNo(orderNo);
            for (ReagentOrderDetail orderDetail : judgeOrderList) {
                if (orderDetail.getUnsendNum() != 0) {
                    isComplate.set(false);
                    break;
                }
            }
            String orderStatus;
            //更新订单状态为已全部配货
            if (isComplate.get()) {
                orderStatus = "5";
            } else {
                //更新订单状态为已配货
                orderStatus = "2";
            }
            orderDao.updateByON(orderNo, orderStatus);

            /*List<String> orderName = new ArrayList<>();
            List<String> orderNumber = new ArrayList<>();
            List<String> preName = new ArrayList<>();
            List<String> preQuantity = new ArrayList<>();

            //先对随货同行单表中的试剂按照名称将数量整合一下，生成一个临时的列表
            List<ReagentPreInDetail> indexDetailList;

            // reagentName为key， 接着如果有重复的，那么从ReagentPreInDetail对象o1与o2中筛选出一个，这里选择o1，
            // 并把reagentName重复，需要将Quantity与o1进行合并的o2, 赋值给o1，最后返回o1
            List<ReagentPreInDetail> preInDetail = new ArrayList<>();
            BeanUtils.copyProperties(reagentPreInDetailList, preInDetail);

            //将详情表中的数据临时拷贝一下，不然数量出错
            List<ReagentPreInDetail> preInDetailList = reagentPreInDetailList.stream().map(t -> {
                ReagentPreInDetail preInDetailItem = new ReagentPreInDetail();
                BeanUtils.copyProperties(t, preInDetailItem);
                return preInDetailItem;
            }).collect(Collectors.toList());

            indexDetailList = new ArrayList<>(preInDetailList.stream().collect(Collectors.toMap(ReagentPreInDetail::getReagentCode, a -> a, (o1, o2) -> {
                o1.setQuantity(o1.getQuantity() + o2.getQuantity());
                return o1;
            })).values());

            //将订单详情中的试剂名称和数量，随货同行单详情中的试剂名称和数量单独提取出来进行比较
            for (ReagentOrderDetail orderDetail : orderDetailList) {
                orderName.add(orderDetail.getReagentCode());
                orderNumber.add(orderDetail.getReagentNumber().toString());
            }
            for (ReagentPreInDetail reagentPreInDetail : indexDetailList) {
                preName.add(reagentPreInDetail.getReagentCode());
                preQuantity.add(reagentPreInDetail.getQuantity().toString());
            }
            //使用list自带的sort方法先进行排序，然后转成toString去判断两个集合是否相等
            orderName.sort(Comparator.comparing(String::hashCode));
            preName.sort(Comparator.comparing(String::hashCode));
            final boolean nameEquals = orderName.toString().equals(preName.toString());

            orderNumber.sort(Comparator.comparing(String::hashCode));
            preQuantity.sort(Comparator.comparing(String::hashCode));

            System.out.println("orderNumber: " + orderNumber);
            System.out.println("preQuantity: " + preQuantity);

            final boolean numEquals = orderNumber.toString().equals(preQuantity.toString());
            System.out.println("numEquals: " + numEquals);

            int count = 1;
            if (orderDetailList.size() != indexDetailList.size()) {
                //与订单不符
                preInBillItem.setBillStatus("4");
                count = 4;
            } else if (nameEquals && !numEquals) {
                //与订单部分相符
                preInBillItem.setBillStatus("3");
                count = 3;
            } else if (nameEquals && numEquals) {
                //与订单完全相符
                preInBillItem.setBillStatus("2");
                count = 2;
            }

            //只有完全相符的订单才生成，否则不生成并且要删除对应的随货同行单详细表
            if (count == 2) {
                preInBillMapper.insert(preInBillItem);
                preInDetailDao.insertBach(reagentPreInDetailList);

                //更新订单状态为已配货
                if (orderNo != null) {
                    String orderStatus = "2";
                    orderDao.updateByON(orderNo, orderStatus);
                }
            } else {
                ReagentPreInDetailItemExample itemExample = new ReagentPreInDetailItemExample();
                itemExample.createCriteria().andBillCodeEqualTo(orderNo);
                preInDetailItemMapper.deleteByExample(itemExample);
            }*/

            //int isPreDetailDone = preInDetailDao.insertBach(reagentPreInDetailList);

            return isPreDone + isPreDetailDone.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    /**
     * 导入信息
     */
    @Override
    public String fileUpload(MultipartFile file, String inDetailId, int cell) {
        String newFilePath = null;
        try {
            String fileName = file.getOriginalFilename();

            //服务器项目路径
            String filePath = System.getProperty("user.dir") + File.separator + "web" + File.separator + "static" + File.separator + "reportFile";
            //本地项目路径
            //String filePath = System.getProperty("user.dir") + File.separator + "frontend" + File.separator + "static" + File.separator + "reportFile";

            //服务器项目路径
            //newFilePath = File.separator + "static" + File.separator + "reportFile" + File.separator + fileName;
            //本地项目路径
            newFilePath = File.separator + "static" + File.separator + "reportFile" + File.separator + fileName;

            switch (cell) {
                case 0:
                    ReagentPreInDetail preInDetail = new ReagentPreInDetail();
                    preInDetail.setUpdateTime(new Date());
                    preInDetail.setReportAddress(newFilePath);
                    ReagentPreInDetailExample preInDetailExample = new ReagentPreInDetailExample();
                    preInDetailExample.createCriteria().andInDetailIdEqualTo(inDetailId);
                    preInDetailMapper.updateByExampleSelective(preInDetail, preInDetailExample);
                    break;
                case 1:
                    ReagentPreInBill preInBill = new ReagentPreInBill();
                    preInBill.setUpdateTime(new Date());
                    preInBill.setElectronicInvoice(newFilePath);
                    ReagentPreInBillExample preInBillExample = new ReagentPreInBillExample();
                    //此处让id等于inDetailId是因为前台电子发票传过来的是id，参数就不变了
                    preInBillExample.createCriteria().andIdEqualTo(Long.valueOf(inDetailId));
                    preInBillMapper.updateByExampleSelective(preInBill, preInBillExample);
                    break;
            }

            //将文件路径写入到表中
            uploadFile(file.getBytes(), filePath, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFilePath;
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            boolean wasSuccessful = targetFile.mkdirs();
        }
        filePath += File.separator;
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 修改预入库单信息
     *
     * @param id
     * @param preInBill
     */
    @Override
    public int update(Long id, ReagentPreInBill preInBill) {
        preInBill.setId(id);
        return preInBillMapper.updateByPrimaryKeySelective(preInBill);
    }

    /**
     * 批量删除订单
     *
     * @param ids
     */
    @Override
    public int delete(List<Long> ids) {
        ReagentPreInBillExample example = new ReagentPreInBillExample();
        example.createCriteria().andIdIn(ids);
        return preInBillMapper.deleteByExample(example);
    }

    /**
     * 分页获取预入库单列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public PageInfo<ReagentPreInBill> list(String keyword, String username, Integer pageSize, Integer pageNum) {

        //先拿username查admin表的admin_id
        //再用admin_id查admin_role表的role_id
        //根据role_id判断是供应商5或者中心库管员2/6
        //if供货商，用username查order表的供货商名，输出该供货商所有数据
        //else中心库管输出所有数据
        //再提交一次

        //创建Page类
        Page<ReagentPreInBill> page = new Page<>(pageNum, pageSize);
        int total;

        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        List<ReagentPreInBill> preInBillList;
        PageHelper.startPage(pageNum, pageSize);
        if (roleId == 5) {
            String supplier = adminDao.selectSupplier(username);
            ReagentSupplierExample supplierExample = new ReagentSupplierExample();
            supplierExample.createCriteria().andSupplierShortNameEqualTo(supplier);
            List<ReagentSupplier> supplierList = supplierMapper.selectByExample(supplierExample);
            String supplierCode = supplierList.get(0).getSupplierCode();
            preInBillList = preInBillDao.selectBySupplier(keyword, supplierCode);
        } else {
            preInBillList = preInBillDao.select(keyword);
        }
        //为Page类中的total属性赋值
        total = preInBillList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        page.addAll(preInBillList.subList(startIndex, endIndex));
        //以Page创建PageInfo
        return new PageInfo<>(page);
    }


    /**
     * 获取部分打印所需数据
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentPreInBillMess> getPrintData(String keyword, String printType, String billType, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ReagentPreInBillMess> billList = null;
        switch (printType) {
            case "1":
                billList = preInBillDao.getPrintData(keyword);
                break;
            case "2":
                billList = orderDao.getPrintData(keyword);
                break;
            case "3":
                if (billType.equals("3")) {
                    billList = inBillDao.getBranchPrintData(keyword);
                } else {
                    billList = inBillDao.getPrintData(keyword);
                }
                break;
            case "4":
                billList = outBillDao.getPrintData(keyword);
                break;
            case "5":
                billList = collectDao.getPrintData(keyword);
                break;
            case "6":
                billList = refundDao.getPrintData(keyword);
                break;
        }

        return billList;
    }


    @Override
    public ReagentPreInBill getItem(Long id) {

        return preInBillMapper.selectByPrimaryKey(id);
    }

    /**
     * @param billStatus
     * @return
     */
    @Override
    public List<ReagentPreInBill> searchByBS(String billStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentPreInBillExample example = new ReagentPreInBillExample();
        ReagentPreInBillExample.Criteria criteria = example.createCriteria();
        criteria.andBillStatusEqualTo(billStatus);
        return preInBillMapper.selectByExample(example);
    }

    /**
     * 查询需要打印的二维码信息
     *
     * @param billCode
     */
    @Override
    public List<ReagentItem> searchCodeList(String billCode) {
        List<ReagentItem> codeList;
        codeList = preInDetailItemDao.searchCodeByBC(billCode);
        return codeList;
    }

}
