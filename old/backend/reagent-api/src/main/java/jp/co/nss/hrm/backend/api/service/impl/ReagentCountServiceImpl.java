package jp.co.nss.hrm.backend.api.service.impl;

import jp.co.nss.hrm.backend.api.dao.*;
import jp.co.nss.hrm.backend.api.dto.ReagentCount;
import jp.co.nss.hrm.backend.api.dto.ReagentEcharts;
import jp.co.nss.hrm.backend.api.service.ReagentCountService;
import jp.co.nss.hrm.backend.mapper.ReagentAdminMapper;
import jp.co.nss.hrm.backend.model.ReagentAdmin;
import jp.co.nss.hrm.backend.model.ReagentAdminExample;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReagentCountServiceImpl implements ReagentCountService {

    @Autowired
    private ReagentStockDao stockDao;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    @Autowired
    private ReagentOrderDao orderDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminMapper adminMapper;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;


    public String getBranch(String username) {
        return adminDao.selectBranch(username);
    }

    public String getStockType(String username) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String stockType = null;
        if (roleId == 1) {
            stockType = null;
        } else if (roleId == 2 || roleId == 4 || roleId == 7) {
            stockType = "1";
        } else if (roleId == 3 || roleId == 6 || roleId == 8 || roleId == 9) {
            stockType = "3";
        }
        return stockType;
    }

    @Override
    public List<ReagentEcharts> chartBar(String username) {

        return stockDetailDao.chartBar(getStockType(username), getBranch(username));
    }

    @Override
    public List<ReagentEcharts> chartBarTop(String username) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String outType = null;
        if (roleId == 3) {
            outType = "2";
        } else if (roleId == 2) {
            outType = "1";
        } else if (roleId == 6) {
            outType = "3";
        }
        return stockDetailDao.chartBarTop(outType, getBranch(username));
    }

    @Override
    public List<ReagentEcharts> chartLine(String username) {
        String supplier = adminDao.selectSupplier(username);
        return orderDao.chartLine(supplier);
    }

    @Override
    public List<ReagentEcharts> chartPie(String username) {

        return stockDetailDao.chartPie(getStockType(username), getBranch(username));
    }

    @Override
    public ReagentCount getCount(String username) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String supplier = adminDao.selectSupplier(username);
        String branch = getBranch(username);
        String orderCount;
        int stockCount;
        String moneyCount;
        String placeOrder;
        String completed;
        String pending;

        ReagentCount count = new ReagentCount();
        orderCount = orderDao.orderCount(supplier);

        //List<ReagentStock> stockListAll = stockDao.selectAll();
        List<ReagentStockDetail> stockDetailListAll = stockDetailDao.selectAll();
        //更新库存详细状态
        int formatTime = 86400000;

        //获取用户最后登录时间
        ReagentAdmin admin = null;
        ReagentAdminExample example = new ReagentAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<ReagentAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
        }
        assert admin != null;
        Date lastLoginTime = admin.getLoginTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        //第一次创建时登录时间为空，目前是注册时将登录时间写为当前时间，所以一般不会为空
        if (lastLoginTime != null) {
            String loginTime = df.format(lastLoginTime);// new Date()为获取当前系统时间，也可使用当前时间戳
            String nowTime = df.format(new Date());

            //将最后登录时间与当前登录时间对比
            //如果是同一天，则不更新状态，否则更新库存信息状态
            if (!loginTime.equals(nowTime)) {
//                for (ReagentStockDetail item : stockDetailListAll) {
//                    Date d1 = stockDetailDao.findMinDate(item.getStockNo(), branch);
//                    Date d2 = new Date();
//                    if (d1 != null) {
//                        long daysBetween = d1.getTime() - d2.getTime();
//                        //111如果小于0，如果222=1或者=0
//                        long diffDate = daysBetween / formatTime;
//                        int daysDiff;
//                        if (daysBetween < 0) {
//                            daysDiff = (int) diffDate;
//                        } else {
//                            daysDiff = (int) (diffDate + 1);
//                        }
//
//                    }
//                }

                //List<ReagentStockDetail> stockDetailListAll = stockDetailDao.selectAll();
                for (ReagentStockDetail item : stockDetailListAll) {
                    if (item.getExpireDate() != null) {
                        Date d1 = item.getExpireDate();
                        Date d2 = new Date();
                        long daysBetween = d1.getTime() - d2.getTime();
                        //111如果小于0，如果222=1或者=0
                        long diffDate = daysBetween / formatTime;
                        int daysDiff;
                        if (daysBetween < 0) {
                            daysDiff = (int) diffDate;
                        } else {
                            daysDiff = (int) (diffDate + 1);
                        }
                        if ((daysDiff <= -1) && item.getReagentStatus().equals("1998")) {
                            stockDetailDao.updateStatus(item.getQrCode(), "2");
                        }
                        stockDetailDao.updateRemainDay(item.getId(), daysDiff);
                    }
                }

                //记录上一次登录时间
                ReagentAdmin record = new ReagentAdmin();
                record.setLoginTime(new Date());
                ReagentAdminExample adminExample = new ReagentAdminExample();
                adminExample.createCriteria().andUsernameEqualTo(username);
                adminMapper.updateByExampleSelective(record, adminExample);
            }
        } else {
            //记录上一次登录时间
            ReagentAdmin record = new ReagentAdmin();
            record.setLoginTime(new Date());
            ReagentAdminExample adminExample = new ReagentAdminExample();
            adminExample.createCriteria().andUsernameEqualTo(username);
            adminMapper.updateByExampleSelective(record, adminExample);
        }

        //计算首页四项数值
        /*for (ReagentStock item : stockListAll) {
         /* String remainDay = stockDao.getDetailRemainDay(item.getStockNo(), branch);
            if (remainDay == null) remainDay = "0";

            item.setBranchName(branch);
            String quantity;
            if (roleId == 4 || roleId == 9) {
                // 试剂操作员的试剂在库数量为 科室库和已出库的试剂总数
                quantity = stockDao.getDetailNumByOperator(item.getStockNo(), branch);
            } else {
                quantity = stockDao.getDetailNum(item.getStockNo(), branch);
            }
            stockCount = stockCount + Integer.parseInt(quantity);
            if (Integer.parseInt(quantity) > 0) {
                if (Integer.parseInt(quantity) <= Integer.parseInt(item.getLowStock())) {
                    lowStockCount++;
                }
                if ((Integer.parseInt(remainDay) <= item.getOverdue()) && item.getOverdueStock() > -2) {
                    overdueCount++;
                }
            }
        }*/

        //计算库存总金额
        moneyCount = stockDetailDao.getMoneyCount(branch);
        String formatMoneyCount;
        if (moneyCount == null || moneyCount.equals("")) {
            formatMoneyCount = "0.00";
        } else {
            BigDecimal bigDecimal = new BigDecimal(moneyCount);
            // 转换为万元（除以10000）
            BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("#0.##");
            // 四舍五入
            formater.setRoundingMode(RoundingMode.FLOOR);
            // 格式化完成之后得出结果
            formatMoneyCount = formater.format(decimal);
        }

        //计算订单状态
        placeOrder = orderDao.placeOrderCount(supplier);
        completed = orderDao.completedCount(supplier);
        pending = orderDao.pendingCount(supplier);

        //计算首页数值
        //overdueCount = Integer.parseInt(stockDao.getOverDueCount(branch));
        if (roleId == 4 || roleId == 9) {
            // 试剂操作员的试剂在库数量为 科室库和已出库的试剂总数
            //lowStockCount = Integer.parseInt(stockDao.getBranchLowStockCount(branch));
            stockCount = Integer.parseInt(stockDao.getBranchStockCount(branch));
        } else {
            //lowStockCount = Integer.parseInt(stockDao.getCenterLowStockCount(branch));
            stockCount = Integer.parseInt(stockDao.getCenterStockCount(branch));
        }

        count.setPlaceOrder(placeOrder);
        count.setCompleted(completed);
        count.setPending(pending);
        count.setStockCount(Integer.toString(stockCount));
        count.setMoneyCount(formatMoneyCount);
        count.setOrderCount(orderCount);
        /*count.setLowStockCount(Integer.toString(lowStockCount));
        count.setOverdueCount(Integer.toString(overdueCount));*/

        return count;
    }

    @Override
    public ReagentCount getHomeCount(String username) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        String branch = getBranch(username);

        int overdueCount;
        int lowStockCount;
        ReagentCount count = new ReagentCount();
        //计算首页数值
        overdueCount = Integer.parseInt(stockDao.getOverDueCount(branch));
        if (roleId == 4 || roleId == 9) {
            // 试剂操作员的试剂在库数量为 科室库和已出库的试剂总数
            lowStockCount = Integer.parseInt(stockDao.getBranchLowStockCount(branch));
        } else {
            lowStockCount = Integer.parseInt(stockDao.getCenterLowStockCount(branch));
        }

        count.setLowStockCount(Integer.toString(lowStockCount));
        count.setOverdueCount(Integer.toString(overdueCount));
        return count;
    }
}
