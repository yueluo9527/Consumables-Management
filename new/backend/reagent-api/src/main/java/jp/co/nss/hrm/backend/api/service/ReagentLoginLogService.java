package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentLoginLogReq;
import jp.co.nss.hrm.backend.model.ReagentAdminLoginLog;

import java.util.List;

public interface ReagentLoginLogService {


    /**
     * 分页获取登录记录列表
     */
    PageInfo<ReagentLoginLogReq> search(Long adminId, String ip, String username, Integer pageSize, Integer pageNum);

}


