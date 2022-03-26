package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentLoginLogReq;

import java.util.List;

public interface ReagentLoginLogDao {

    List<ReagentLoginLogReq> searchByDouble(Long adminId, String ip);

    int timedDeletion();
}
