package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentAdminParam;
import jp.co.nss.hrm.backend.api.dto.UpdateAdminPasswordParam;
import jp.co.nss.hrm.backend.model.ReagentAdmin;
import jp.co.nss.hrm.backend.model.ReagentResource;
import jp.co.nss.hrm.backend.model.ReagentRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
public interface ReagentAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    ReagentAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    ReagentAdmin register(ReagentAdminParam ReagentAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 刷新token的功能
     *
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     */
    ReagentAdmin getItem(Long id);

    /**
     * 根据用户名获取用户真实姓名
     */
    List<ReagentAdmin> getTrueName(String username);

    /**
     * 根据用户名或昵称分页查询用户
     */
    PageInfo<ReagentAdmin> list(String keyword, String username, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, ReagentAdmin admin, String username);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<ReagentRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<ReagentResource> getResourceList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    int checkUserFromBranch(String usernameCurrent, String usernameTarget);

    /**
     * 获取指定科室所有的试剂操作员
     * @param branch 科室名
     * @return  List<ReagentAdmin>
     */
    List<ReagentAdmin> getOperatorList(String branch);
}
