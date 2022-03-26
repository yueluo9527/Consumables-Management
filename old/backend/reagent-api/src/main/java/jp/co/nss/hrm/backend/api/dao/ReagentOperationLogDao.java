package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentOperationLog;

import java.util.List;

public interface ReagentOperationLogDao {

    List<ReagentOperationLog> searchByDouble(String module, String userName, String result);

    int timedDeletion();
}
