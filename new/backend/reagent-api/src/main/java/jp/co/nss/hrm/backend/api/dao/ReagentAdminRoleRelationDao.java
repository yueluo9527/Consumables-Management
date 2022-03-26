package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentAdminParam;
import jp.co.nss.hrm.backend.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义后台用户与角色管理Dao
 * Created by macro on 2018/10/8.
 */
public interface ReagentAdminRoleRelationDao {

    Long selectByAdmin(@Param("adminId") Long adminId);

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<ReagentAdminRoleRelation> adminRoleRelationList);

    /**
     * 插入默认角色
     */
    int insertRoleId(@Param("adminId") Long adminId, @Param("roleId") Long roleId);

    /**
     * 获取用于所有角色
     */
    List<ReagentRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<ReagentResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    /**
     * 获取角色对应用户数量
     */
    List<ReagentRole> getUserCount();
}
