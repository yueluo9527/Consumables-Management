package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentLoginLogDao;
import jp.co.nss.hrm.backend.api.dto.ReagentLoginLogReq;
import jp.co.nss.hrm.backend.api.service.ReagentLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReagentLoginLogServiceImpl implements ReagentLoginLogService {

    @Autowired
    private ReagentLoginLogDao loginLogDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    /**
     * @param adminId
     * @param ip
     * @return
     */
    @Override
    public PageInfo<ReagentLoginLogReq> search(Long adminId, String ip, String username, Integer pageSize, Integer pageNum) {
        //删除一月之前的数据
        loginLogDao.timedDeletion();

        Long loginId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(loginId);
        List<ReagentLoginLogReq> adminLoginLogs;
        List<ReagentLoginLogReq> adminLoginLog = new ArrayList<>();

        //创建Page类
        Page<ReagentLoginLogReq> page = new Page<>(pageNum, pageSize);
        int total;

        adminLoginLogs = loginLogDao.searchByDouble(adminId, ip);

        if (roleId == 1) {
            //为Page类中的total属性赋值
            total = adminLoginLogs.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(adminLoginLogs.subList(startIndex, endIndex));
        } else {
            for (ReagentLoginLogReq log : adminLoginLogs) {
                if (log.getAdminId() != 1) {
                    adminLoginLog.add(log);
                }
            }
            //为Page类中的total属性赋值
            total = adminLoginLog.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(adminLoginLog.subList(startIndex, endIndex));
        }
        //以Page创建PageInfo
        return new PageInfo<>(page);
    }
}
