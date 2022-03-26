package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.api.service.ReagentStockDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentStockDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentStock;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import jp.co.nss.hrm.backend.model.ReagentStockDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ReagentStockDetailServiceImpl implements ReagentStockDetailService {

    @Autowired
    private ReagentStockDetailMapper stockDetailMapper;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentStockDao stockDao;

    @Autowired
    private ReagentInBillDao inBillDao;

    @Autowired
    private ReagentRefundDao refundDao;

    @Autowired
    private ReagentOutBillDao outBillDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    /**
     * 获取所有中心库库存详细信息
     */
    @Override
    public List<ReagentStockDetail> list() {

        return stockDetailMapper.selectByExample(new ReagentStockDetailExample());
    }

    /**
     * 添加中心库库存详细信息
     *
     * @param stock
     */
    @Override
    public int create(ReagentStockDetail stock) {
        stock.setCreateTime(new Date());
        return stockDetailMapper.insert(stock);
    }

    /**
     * 修改中心库库存详细信息
     *
     * @param id
     * @param stock
     */
    @Override
    public int update(Long id, ReagentStockDetail stock) {
        stock.setId(id);
        return stockDetailMapper.updateByPrimaryKeySelective(stock);
    }

    /**
     * 批量删除中心库库存详细信息
     *
     * @param allocId
     */

    @Override
    public int delete(Long allocId) {
        ReagentStockDetailExample example = new ReagentStockDetailExample();
        example.createCriteria().andIdEqualTo(allocId);
        int count = stockDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 判断试剂信息是否在库
     *
     * @param code
     */

    @Override
    public String isInStock(Long code) {
        List<String> isflag = stockDetailDao.isInStock(code);
        //System.out.println("reagent:" + isflag);
        String flag;
        //isflag.size()>0,flag = 1，试剂在库；
        //isflag.size()=0,flag = 0，试剂不在库
        if (isflag.size() > 0) flag = "1";
        else flag = "0";

        return flag;
    }

    /**
     * 判断供货商是否被禁用
     *
     * @param shortName
     */

    @Override
    public String isSupInStock(String shortName) {
        List<String> isflag = stockDetailDao.isSupInStock(shortName);
        //System.out.println("supplier:" + isflag);
        String flag;
        //isflag.size()>0,flag = 1，未被禁用；
        //isflag.size()=0,flag = 0，被禁用
        if (isflag.size() > 0) flag = "1";
        else flag = "0";

        return flag;
    }

    /**
     * 分页获取中心库库存详细信息
     */
    @Override
    public List<ReagentStockDetail> list(ReagentStockDetailReq stockDetailReq) {
        String branch = adminDao.selectBranch(stockDetailReq.getUsername());
        PageHelper.startPage(stockDetailReq.getPageNum(), stockDetailReq.getPageSize());
        return stockDetailDao.selectByStockNo(stockDetailReq.getKeyword(), stockDetailReq.getReagentCode(),
                stockDetailReq.getBatchNo(), stockDetailReq.getExpireDate(),
                stockDetailReq.getEnterTime(), stockDetailReq.getEnterNo(),
                stockDetailReq.getEnterMan(), stockDetailReq.getEnterMan(),
                stockDetailReq.getOutTime(), stockDetailReq.getOutNo(),
                stockDetailReq.getOutMan(), branch);
    }

    /**
     * 分页获取中心库库存详细信息
     */
    @Override
    public List<ReagentStockDetail> fetchSearch(ReagentStockDetailReq stockDetailReq) {
        String branch = adminDao.selectBranch(stockDetailReq.getUsername());
        PageHelper.startPage(stockDetailReq.getPageNum(), stockDetailReq.getPageSize());
        return stockDetailDao.fetchSearch(stockDetailReq.getReagentCode(),
                stockDetailReq.getBatchNo(), stockDetailReq.getExpireDate(),
                stockDetailReq.getEnterTime(), stockDetailReq.getEnterNo(),
                stockDetailReq.getEnterMan(), stockDetailReq.getEnterMan(),
                stockDetailReq.getOutTime(), stockDetailReq.getOutNo(),
                stockDetailReq.getOutMan(), stockDetailReq.getReagentName(),
                stockDetailReq.getManufacturerName(), stockDetailReq.getSupplierShortName(),
                stockDetailReq.getReagentStatus(), stockDetailReq.getReagentTemp(), branch);
    }

    @Override
    public List<ReagentStockDetail> lossList(String reagentId, String reagentStatus, String username, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);
        PageHelper.startPage(pageNum, pageSize);

        return stockDetailDao.selectLoss(reagentId, branch, reagentStatus);
    }

    @Override
    public List<ReagentLossSummary> lossSummary(String keyword, String username, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);
        PageHelper.startPage(pageNum, pageSize);
        return stockDetailDao.lossSummary(keyword, branch);
    }

    /**
     * web单个更新库损状态
     *
     * @param qrCode
     * @param lossId
     */
    @Override
    public int updateStatus(String qrCode, String lossId) {
        return stockDetailDao.updateStatus(qrCode, lossId);
    }

    /**
     * PDA批量更新库损状态
     *
     * @param stockLoss
     */
    @Override
    public int updateStatusList(ReagentStockReqPost stockLoss) {
        String lossId = stockLoss.getReagentStatus();
        List<String> qrList = stockLoss.getQrList();
        try {
            //批量库损更新在库状态resultType="jp.co.nss.hrm.backend.api.dto.ReagentPreInItem"
            stockDetailDao.updateFetchStatus(lossId, qrList, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    /**
     * 在库查询-扫码查询
     */
    @Override
    public GetReagentItem findReagentItem(String qrCode, String username, String isMore) {
        Long adminId = adminDao.selectByUser(username);
        String userBranch = adminDao.selectBranch(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);

        ReagentItem item = stockDetailDao.findReagentItem(qrCode);

        GetReagentItem res = new GetReagentItem();

        // 无在库数据
        if (item == null) {
            res.setCode(0);
            res.setMsg("未找到该试剂");
            return res;
        }

        // start: 判断权限
        String itemBranch = item.getBranch();
        String itemApplyMan = item.getApplyMan();
        String NOT_AUTH = "试剂未在库中";

        if (roleId == 1) { // 超管
            // 默认权限最高，暂规定为可操作所有
        } else if (roleId == 2 || roleId == 6) { // 一级、二级中心库管员
            // 不属于当前科室，则不能操作
            if (!userBranch.equals(itemBranch)) {
                res.setCode(0);
                res.setMsg(NOT_AUTH);
                return res;
            }
            if (!item.getReagentStatus().equals("1998")) {
                res.setCode(0);
                res.setMsg(NOT_AUTH);
                return res;
            }
        } else if (roleId == 3) {   // 二级科室管理员
            // 没有移库或不属于当前科室
            if (itemBranch == null || itemBranch.equals("") || !itemBranch.equals(userBranch)) {
                res.setCode(0);
                res.setMsg(NOT_AUTH);
                return res;
            }
            // 试剂已从中心库出库，但还未申领入库
            if (item.getReagentStatus().equals("1997")) {
                res.setCode(0);
                res.setMsg("试剂未申领入库");
                return res;
            }
            // 已出库给试剂操作员
            if (item.getReagentStatus().equals("1999")) {
                res.setCode(0);
                res.setMsg("试剂已出库");
                return res;
            }
        } else if (roleId == 4 || roleId == 9) { // 一级、二级操作员
            // 不属于当前操作员的科室
            if (!userBranch.equals(itemBranch)) {
                res.setCode(0);
                res.setMsg(NOT_AUTH);
                return res;
            }
            // 试剂操作员可以出库科室库未出库的试剂
            // 中心已经移库，但还没有申领入库
            if (item.getReagentStatus().equals("1997")) {
                res.setCode(0);
                res.setMsg("试剂未申领入库");
                return res;
            }
            // 已出库但不属于当前操作员
//            if (!itemApplyMan.equals(username)) {
//                res.setCode(0);
//                res.setMsg("无操作权限");
//                return res;
//            }
        }
        // end: 判断权限

        // 权限校验通过，检查试剂状态
        // start: 需要检查试剂状态，非正常状态不能被查找到
        if (isMore == null || isMore.equals("")) {
            // 检查试剂状态
            // 状态: 0：丢失，1：破损，2：过期，3：用尽，4.其他，1997：中心库已确认移库，需科室库确认申领，1998：正常在库；1999：科室已出库
            switch (item.getReagentStatus()) {
                case "0":
                    res.setMsg("试剂已丢失");
                    break;
                case "1":
                    res.setMsg("试剂已破损");
                    break;
                case "2":
                    res.setMsg("试剂已过期");
                    break;
                case "3":
                    res.setMsg("试剂已用尽");
                    break;
                case "4":
                    res.setMsg("试剂因为其它原因已被库损");
                    break;
            }

            // 非正常状态
            if (res.getMsg() != null) {
                res.setCode(0);
                return res;
            }

            // 过期的试剂状态码可能没有更新，需要额外判断过期时间
            Date dateNow = new Date();
            Date dateExpire = item.getExpireDate();
            if (dateNow.after(dateExpire)) {
                res.setCode(0);
                res.setMsg("试剂已过期");
                return res;
            }

        }
        // end: 需要检查试剂状态，非正常状态不能被查找到

        // 所有校验通过，该用户可查询到当前试剂
        res.setCode(1);
        res.setData(item);
        return res;
    }

    /**
     * 获取比当前试剂更早过期的试剂数组
     */
    @Override
    public List<ReagentItem> getReagentEarlier(ReagentItem reagent, String username) {
        String userBranch = adminDao.selectBranch(username);
        String applyMan = reagent.getApplyMan();

        List<ReagentItem> arrResult;
        arrResult = stockDetailDao.getReagentEarlier(reagent, userBranch, applyMan);

        return arrResult;
    }

    /**
     * 库损报表
     */
    @Override
    public List<ReagentStatus> lossCount(String username, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        String stockType = null;
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String branch = adminDao.selectBranch(username);
        if (roleId == 2) {
            stockType = "1";
        } else if (roleId == 6 || roleId == 3) {
            stockType = "3";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ReagentStatus> lossList = stockDetailDao.countStatus(stockType, branch, startTime, endTime);
        for (ReagentStatus item : lossList) {
            switch (item.getReagentStatus()) {
                case "0":
                    item.setReagentStatus("丢失");
                    break;
                case "1":
                    item.setReagentStatus("破损");
                    break;
                case "2":
                    item.setReagentStatus("过期");
                    break;
                case "4":
                    item.setReagentStatus("其他原因库损");
                    break;
            }
        }
        return lossList;
    }

    /**
     * 出入库报表
     */
    @Override
    public List<ReagentStatus> countOutIn(String username, String supplier, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        String outType = null;
        String inType = null;
        String refundType = null;
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String branch = adminDao.selectBranch(username);
        if (roleId == 3) {
            outType = "2";
            inType = "3";
            refundType = "3";
        } else if (roleId == 2) {
            outType = "1";
            inType = "1";
            refundType = "1";
        } else if (roleId == 6) {
            outType = "3";
            inType = "2";
            refundType = "2";
        }
        PageHelper.startPage(pageNum, pageSize);
        ReagentStatus inList = inBillDao.countIn(inType, branch, supplier, startTime, endTime);
        ReagentStatus refundList = refundDao.countOutIn(refundType, branch, supplier, startTime, endTime);
        ReagentStatus outList = outBillDao.countOut(outType, branch, supplier, startTime, endTime);

        List<ReagentStatus> outInList = new ArrayList<>();
        ReagentStatus inCount = new ReagentStatus();
        ReagentStatus refundCount = new ReagentStatus();
        ReagentStatus outCount = new ReagentStatus();

        if (inList != null) {
            inCount.setReagentStatus("入库");
            inCount.setStatusCount(inList.getStatusCount());
            inCount.setSumPrice(inList.getSumPrice());
            outInList.add(inCount);
        }

        if (refundList != null) {
            refundCount.setReagentStatus("退货");
            refundCount.setStatusCount(refundList.getStatusCount());
            refundCount.setSumPrice(refundList.getSumPrice());
            outInList.add(refundCount);
        }

        if (outList != null) {
            outCount.setReagentStatus("出库");
            outCount.setStatusCount(outList.getStatusCount());
            outCount.setSumPrice(outList.getSumPrice());
            outInList.add(outCount);
        }
        if (inList != null && refundList != null) {
            ReagentStatus JingRuKu = new ReagentStatus();
            JingRuKu.setReagentStatus("净入库");
            JingRuKu.setStatusCount(inList.getStatusCount() - refundList.getStatusCount());
            JingRuKu.setSumPrice(inList.getSumPrice() - refundList.getSumPrice());
            if (JingRuKu != null) {
                outInList.add(JingRuKu);
            }
        }

        return outInList;
    }

    /**
     * 试剂出入库报表
     */
    @Override
    public PageInfo<ReagentOutIn> reagentOutIn(String username, String supplier, String reagentName, String branchName, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        if (branchName != null) {
            branch = branchName;
        }
//        if (roleId == 6 && reagentName!=null) {
//            branch = branchName;
//        }
        List<ReagentOutIn> reagentOutInList = inBillDao.reagentOutIn(branch, supplier, reagentName, startTime, endTime);
        reagentOutInList.removeIf(Objects::isNull);
        //创建Page类
        Page<ReagentOutIn> page = new Page<>(pageNum, pageSize);
        int total;

        for (ReagentOutIn item : reagentOutInList) {
            if (item != null) {
                if (item.getInQuantity() == null) {
                    item.setInQuantity(0L);
                }
                if (item.getRefundQuantity() == null) {
                    item.setRefundQuantity(0L);
                }
                if (item.getOutQuantity() == null) {
                    item.setOutQuantity(0L);
                }
                item.setCleanQuantity(item.getInQuantity() - item.getRefundQuantity());
                item.setCleanTotal(item.getInTotal() - item.getRefundTotal());
            }
        }

        for (int i = 0; i < reagentOutInList.size(); i++) {
            if (reagentOutInList.get(i).getInQuantity() == 0
                    && reagentOutInList.get(i).getRefundQuantity() == 0
                    && reagentOutInList.get(i).getOutQuantity() == 0) {
                reagentOutInList.remove(i);
                i--;
            }
        }
        //为Page类中的total属性赋值
        total = reagentOutInList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        if (startIndex > endIndex) startIndex = 0;
        page.addAll(reagentOutInList.subList(startIndex, endIndex));

        //以Page创建PageInfo
        return new PageInfo<>(page);
    }

    /**
     * 试剂总和报表
     */
    @Override
    public PageInfo<ReagentStock> reagentOverall(String username, String supplier, String reagentName, String branchName, String startTime, String endTime, Integer pageSize, Integer pageNum) {

        List<ReagentStock> overallList = stockDetailDao.reagentOverall(branchName, supplier, reagentName, startTime, endTime);

        //创建Page类
        Page<ReagentStock> page = new Page<>(pageNum, pageSize);
        int total;
        //为Page类中的total属性赋值
        total = overallList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        if (startIndex > endIndex) startIndex = 0;
        page.addAll(overallList.subList(startIndex, endIndex));

        //以Page创建PageInfo
        return new PageInfo<>(page);

    }

    /**
     * 试剂使用记录报表
     */
    @Override
    public PageInfo<ReagentDetailReq> reagentUseLog(String username, String keyword, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String branch = adminDao.selectBranch(username);

        List<ReagentDetailReq> reagentDeviceLogList = stockDetailDao.reagentUseLog(keyword, branch, reagentName, startTime, endTime);

        //创建Page类
        Page<ReagentDetailReq> page = new Page<>(pageNum, pageSize);
        int total;
        if (roleId != 4 && roleId != 5 && roleId != 6 && roleId != 9 && roleId != 10) {
            //为Page类中的total属性赋值
            total = reagentDeviceLogList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            if (startIndex > endIndex) startIndex = 0;
            page.addAll(reagentDeviceLogList.subList(startIndex, endIndex));

            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else return null;
    }

    @Override
    public int endReagent(ReagentStockReqPost stockEnd) {
        String reagentStatus = stockEnd.getReagentStatus();
        List<String> qrList = stockEnd.getQrList();
        try {
            //批量终结试剂 0：丢失，1：破损，2：过期，3：其他，4.用尽
            stockDetailDao.updateFetchStatus(reagentStatus, qrList, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }

    /**
     * 获取试剂操作员名下的试剂
     *
     * @param username 用户名
     * @return List<ReagentStock>
     */
    public List<ReagentStock> getOperatorList(String username, String stockType) {
        String reagentStatus = "1999";
        String branch = adminDao.selectBranch(username);

        return stockDetailDao.selectByOperator(stockType, username, branch, reagentStatus);
    }

    /**
     * 更新单个试剂的开启有效期限
     *
     * @param username String
     * @param days     String
     * @param qrcode   String
     * @return int
     */
    public int updateEffectiveOpenTime(String username, String days, String qrcode) {
        int d;
        try {
            d = Integer.parseInt(days);
        } catch (NumberFormatException e) {
            d = 0;
        }
        Long adminId = adminDao.selectByUser(username);
        return stockDetailDao.updateEffectiveOpenTime(adminId, d, qrcode);
    }

    public int updateDevice(String qrcode, Long deviceId, Long userId) {
        return stockDetailDao.updateDeviceInfo(qrcode, deviceId, userId, new Date());
    }

    public int getDeptStockNumberByReagentId(long reagentId) {
        return stockDetailDao.getDeptStockNumberByReagentId(reagentId);
    }

}
