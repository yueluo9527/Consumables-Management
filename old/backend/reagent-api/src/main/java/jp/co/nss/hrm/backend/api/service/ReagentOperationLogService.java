package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.model.ReagentOperationLog;

import java.util.List;

public interface ReagentOperationLogService {

    /**
     * 分页获取试剂列表
     */
    List<ReagentOperationLog> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 组合查询
     */
    PageInfo<ReagentOperationLog> search(String module, String userName, String result, String username, Integer pageSize, Integer pageNum);

}


