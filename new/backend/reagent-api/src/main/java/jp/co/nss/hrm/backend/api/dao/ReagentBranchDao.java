package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentBranch;
import jp.co.nss.hrm.backend.model.ReagentMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentBranchDao {

    /**
     * 根据科室名称获取列表
     */
    List<ReagentBranch> getAllByBranchName(@Param("branchName") String branchName);

    String getMaxId();
}
