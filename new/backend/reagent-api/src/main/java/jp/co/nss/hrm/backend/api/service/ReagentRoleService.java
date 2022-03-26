package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.model.ReagentMenu;
import jp.co.nss.hrm.backend.model.ReagentResource;
import jp.co.nss.hrm.backend.model.ReagentRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ReagentRoleService {
    /**
     * 添加角色
     */
    int create(ReagentRole role);

    /**
     * 修改角色信息
     */
    int update(Long id, ReagentRole role);

    /**
     * 批量删除角色
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     */
    List<ReagentRole> list();

    /**
     * 分页获取角色列表
     */
    PageInfo<ReagentRole> list(String keyword, String username, Integer pageSize, Integer pageNum);

    /**
     * 根据用户名获取角色列表
     */
    List<ReagentRole> getRoleListByAdmin(String adminName);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<ReagentMenu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<ReagentMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<ReagentResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
