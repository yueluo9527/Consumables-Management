package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentOperationLogDao;
import jp.co.nss.hrm.backend.api.service.ReagentOperationLogService;
import jp.co.nss.hrm.backend.mapper.ReagentOperationLogMapper;
import jp.co.nss.hrm.backend.model.ReagentOperationLog;
import jp.co.nss.hrm.backend.model.ReagentOperationLogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReagentOperationLogServiceImpl implements ReagentOperationLogService {

    @Autowired
    private ReagentOperationLogMapper operationLogMapper;
    @Autowired
    private ReagentOperationLogDao operationLogDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    /**
     * 分页获取试剂信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentOperationLog> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentOperationLogExample example = new ReagentOperationLogExample();
        ReagentOperationLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andModuleLike("%" + keyword + "%");
            example.or(example.createCriteria().andUserNameLike("%" + keyword + "%"));
            example.or(example.createCriteria().andResultLike("%" + keyword + "%"));
        }

        return operationLogMapper.selectByExample(example);
    }

    /**
     * @param module
     * @param userName
     * @param result
     * @return
     */
    @Override
    public PageInfo<ReagentOperationLog> search(String module, String userName, String result, String username, Integer pageSize, Integer pageNum) {
        //删除一月之前的数据
        operationLogDao.timedDeletion();

        Long loginId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(loginId);

        List<ReagentOperationLog> operationLogList;
        List<ReagentOperationLog> operationLogs = new ArrayList<>();
        operationLogList = operationLogDao.searchByDouble(module, userName, result);

        //创建Page类
        Page<ReagentOperationLog> page = new Page<>(pageNum, pageSize);
        int total;
        if (roleId == 1) {
            //为Page类中的total属性赋值
            total = operationLogList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(operationLogList.subList(startIndex, endIndex));
        } else if (roleId == 7) {
            for (ReagentOperationLog reagentOperationLog : operationLogList) {
                if (reagentOperationLog.getUserId() == null || reagentOperationLog.getUserId() == 2 || reagentOperationLog.getUserId() == 4 || reagentOperationLog.getUserId() == 5 || reagentOperationLog.getUserId() == 7 || reagentOperationLog.getUserId() == 10) {
                    operationLogs.add(reagentOperationLog);
                }
            }
            //为Page类中的total属性赋值
            total = operationLogs.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(operationLogs.subList(startIndex, endIndex));
        } else if (roleId == 8) {
            for (ReagentOperationLog reagentOperationLog : operationLogList) {
                //此处将==null判断条件放在前面是万一userId为null，null是不可以和数字直接比较的
                if (reagentOperationLog.getUserId() == null || reagentOperationLog.getUserId() == 3 || reagentOperationLog.getUserId() == 5 || reagentOperationLog.getUserId() == 6 || reagentOperationLog.getUserId() == 8 || reagentOperationLog.getUserId() == 9 || reagentOperationLog.getUserId() == 10) {
                    operationLogs.add(reagentOperationLog);
                }
            }
            //为Page类中的total属性赋值
            total = operationLogs.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(operationLogs.subList(startIndex, endIndex));
        }

        //以Page创建PageInfo
        return new PageInfo<>(page);
    }
}
