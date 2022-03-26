package jp.co.nss.hrm.backend.api.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.ReagentDetailReq;
import jp.co.nss.hrm.backend.api.dto.ReagentOutBillReq;
import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;
import jp.co.nss.hrm.backend.api.enums.BillStatus;
import jp.co.nss.hrm.backend.api.enums.BillType;
import jp.co.nss.hrm.backend.api.enums.StockStaus;
import jp.co.nss.hrm.backend.api.service.ReagentOutBillService;
import jp.co.nss.hrm.backend.mapper.*;
import jp.co.nss.hrm.backend.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ReagentOutBillServiceImpl implements ReagentOutBillService {

    @Autowired
    private ReagentOutBillMapper outBillMapper;

    @Autowired
    private ReagentOutBillDao outBillDao;

    @Autowired
    private ReagentStockMapper stockMapper;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentOutDetailMapper outDetailMapper;

    @Autowired
    private ReagentOutDetailDao outDetailDao;

    @Autowired
    private ReagentOutItemDao outDetailItemDao;

    @Autowired
    private ReagentOutDetailItemMapper outItemMapper;

    @Autowired
    private ReagentStockItemMapper stockItemMapper;

    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    @Autowired
    private ReagentStockDao stockDao;

    @Override
    public List<ReagentOutBill> getAllByBillType(String billType) {

        return outBillDao.getAllByBillType(billType);
    }

    @Override
    public List<ReagentOutBill> list(String billType, String keyword, String username, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);
        PageHelper.startPage(pageNum, pageSize);
        List<ReagentOutBill> outBillList;
        outBillList = outBillDao.selectByBranch(billType, keyword, branch);

        return outBillList;
    }

    @Override
    public List<ReagentOutBill> list(String billType, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentOutBillExample example = new ReagentOutBillExample();
        ReagentOutBillExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(billType)) {
            criteria.andBillTypeEqualTo(billType);
        }
        return outBillMapper.selectByExample(example);
    }

    @Override
    public int createOutDoc(ReagentOutBillReq req) {
        try {
            //出库信息检索
            ReagentOutBill outBill = new ReagentOutBill();
            BeanUtils.copyProperties(req, outBill);
            Long adminId = adminDao.selectByUser(req.getBillCreator());
            Long roleId = adminRoleDao.selectByAdmin(adminId);
            String branch = adminDao.selectBranch(req.getBillCreator());

            //出库单第一层
            Date timeNow = new Date();

            Long time1 = new Date().getTime();
            Random ne2 = new Random();//实例化一个random的对象ne
            int x2 = ne2.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
            String random_order2 = String.valueOf(x2);
            String billCode = time1 + random_order2;

            // 出库单种类：1-科室库 单级领用/移库/退货出库单
            // 2-科室库领用/移库/退货出库单
            // 3-中心库移库/退货出库单
            String billType = null;
            if (roleId == 2) {
                billType = "1";
            } else if (roleId == 3 || roleId == 9) {
                // 试剂操作员也可以出库科室试剂
                billType = "2";
            }

            outBill.setBillCode(billCode);
            outBill.setBillType(billType);
            outBill.setBillDate(DateUtil.parse(req.getBillDate(), "yyyyMMdd"));
            outBill.setBillStatus(BillStatus.real.getValue());
            outBill.setBillCreator(req.getBillCreator());
            outBill.setRemark(req.getRemark());
            outBill.setBranchName(branch);
            outBill.setUpdateTime(timeNow);
            outBill.setCreateTime(timeNow);
            outBill.setApplicationDate(timeNow);
            outBill.setApplicationUser(req.getApplicationUser());
            outBillMapper.insert(outBill);

            //出库单详细第二层
            List<ReagentDetailReq> list = req.getDetails();
            List<ReagentOutDetail> outDetailList = new ArrayList<>();
            for (ReagentDetailReq detail : list) {
                ReagentStock stock = stockDao.selectByBillId(detail.getId().toString());
                ReagentOutDetail outDetail = new ReagentOutDetail();
                BeanUtils.copyProperties(stock, outDetail);

                //生成出库单详情号
                Long time2 = new Date().getTime();
                Random ne3 = new Random();//实例化一个random的对象ne
                int x3 = ne3.nextInt(999 - 100 + 1) + 100;//为变量赋随机值100-999
                String random_order3 = String.valueOf(x3);
                String outDetailId = time2 + random_order3;

                outDetail.setId(outBill.getId());
                outDetail.setBillCode(billCode);
                outDetail.setOutDetailId(outDetailId);
                outDetail.setReagentId(detail.getReagentId().toString());
                outDetail.setReagentSpecification(detail.getReagentSpecification());
                outDetail.setBatchNo(detail.getBatchNo());
                outDetail.setFactory(detail.getFactory());
                outDetail.setRegistrationNo(detail.getRegistrationNo());
                outDetail.setSupplierShortName(detail.getSupplierShortName());
                outDetail.setReagentUnit(detail.getReagentUnit());
                outDetail.setPrice(detail.getPrice());
                outDetail.setQuantity(detail.getQuantity());
                outDetail.setTotal(detail.getTotal());
                outDetail.setExpireDate(detail.getExpireDate());
                outDetail.setCreateTime(timeNow);
                outDetail.setCreateBy(req.getBillCreator());
                outDetail.setApplicationUser(req.getApplicationUser());
                outDetail.setUpdateTime(timeNow);
                outDetail.setUpdateBy(req.getBillCreator());
                outDetailList.add(outDetail);

                //出库第三层-QR信息
                List<String> qrList = detail.getQrList();
                List<ReagentOutDetailItem> reagentOutDetailItemsList = new ArrayList<>();
                for (int i = 0; i < qrList.size(); i++) {
                    ReagentOutDetailItem item = new ReagentOutDetailItem();
                    item.setBillCode(billCode);
                    item.setOutDetailId(outDetailId);
                    item.setCreateTime(timeNow);
                    item.setCreateBy(req.getBillCreator());
                    item.setUpdateBy(req.getBillCreator());
                    item.setUpdateTime(timeNow);
                    item.setReagentCode(detail.getReagentCodeList().get(i));
                    item.setQrCode(detail.getQrList().get(i));
                    item.setCodeValue(detail.getQrCodeValueList().get(i));

                    reagentOutDetailItemsList.add(item);
                }
                outDetailItemDao.insertItem(reagentOutDetailItemsList);

                stockDetailDao.updateApplyMan(req.getApplicationUser(), qrList);
                int a = stockDetailDao.updateOutInfo(adminId, req.getBillCreator(), timeNow, qrList);
                // 出库试剂的状态码为 1999
                stockDetailDao.updateFetchStatus("1999", qrList, null);
            }
            outDetailDao.insertOutDetail(outDetailList);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    @Override
    @Transactional
    public int createOutBill(ReagentOutBillReq req) {
        try {
            //入库情报检索
            ReagentOutBill bill = new ReagentOutBill();

            BeanUtils.copyProperties(req, bill);

            //出库单登录
            bill.setBillType(BillType.in_act.getValue());
            bill.setBillDate(DateUtil.parse(req.getBillDate(), "yyyyMMdd"));
            bill.setBillStatus(BillStatus.real.getValue());
            bill.setUpdateTime(new Date());
            bill.setCreateTime(new Date());
            int billId = outBillMapper.insert(bill);

            //出库单详细登录
            List<ReagentDetailReq> list = req.getDetails();
            for (ReagentDetailReq detail : list) {
                //入库单详细登录
                ReagentStock stock = stockMapper.selectByPrimaryKey(detail.getId());
                ReagentOutDetail outDetail = new ReagentOutDetail();
                BeanUtils.copyProperties(stock, outDetail);
                outDetail.setId(bill.getId());
                outDetail.setCreateTime(new Date());
                outDetail.setQuantity((long) detail.getQrList().size());
                int detailId = outDetailMapper.insert(outDetail);

                //在库更新
                //stock.setQuantity(stock.getQuantity() - outDetail.getQuantity() );
                //stockMapper.updateByPrimaryKeySelective(stock);


                //QR登録
                List<String> qrList = detail.getQrList();
                for (int i = 0; i < qrList.size(); i++) {
                    String qrCode = qrList.get(i);
                    Long id = detail.getQrIdList().get(i);
                    //出库单QR登录
                    ReagentOutDetailItem item = new ReagentOutDetailItem();
                    item.setOutDetailId(outDetail.getOutDetailId());
                    item.setQrCode(qrCode);
                    item.setCreateTime(new Date());
                    item.setCreateBy(req.getBillCreator());
                    item.setStatus("1");
                    item.setUpdateTime(new Date());
                    item.setUpdateBy(req.getBillCreator());
                    item.setDeleteFlag((byte) 0); // todo DB修正
//                    outItemMapper.insert(item);

                    //在库QR修正
                    ReagentStockItem stockItem = new ReagentStockItem();
                    stockItem.setId(id);
                    if (BillType.out_user.getValue().equals(req.getBillType())) {
                        stockItem.setConsumerId(req.getConsumerId());
                        stockItem.setStatus(StockStaus.using.getValue());

                    } else {
                        stockItem.setBranchId(1000L);
                        stockItem.setStatus(StockStaus.in.getValue());
                    }
                    stockItem.setUpdateTime(new Date());
                    stockItem.setUpdateBy(req.getBillCreator());
                    stockItemMapper.updateByPrimaryKeySelective(stockItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    /**
     * 批量删除订单
     *
     * @param ids
     */
    @Override
    public int delete(List<Long> ids) {
        ReagentOutBillExample example = new ReagentOutBillExample();
        example.createCriteria().andIdIn(ids);
        int count = outBillMapper.deleteByExample(example);
        return count;
    }
}
