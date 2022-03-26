package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentMenu;
import jp.co.nss.hrm.backend.model.ReagentResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义后台角色管理Dao
 * Created by macro on 2020/2/2.
 */
public interface ReagentRoleDao {
    /**
     * 根据后台用户ID获取菜单
     */
    List<ReagentMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<ReagentMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<ReagentResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
