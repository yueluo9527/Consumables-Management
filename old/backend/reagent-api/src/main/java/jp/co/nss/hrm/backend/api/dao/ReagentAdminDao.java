package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentAdminDao {

    String selectBranch(@Param("username") String username);

    String selectGroupName(@Param("username") String username);

    String selectSupplier(@Param("username") String username);

    Long selectByUser(@Param("username") String username);

    int checkUserFromBranch(@Param("branch") String branch,
                            @Param("username") String username);

    List<ReagentAdmin> getOperatorList(@Param("branch") String branch);

}
