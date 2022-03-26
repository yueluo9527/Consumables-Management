package jp.co.nss.hrm.backend.api.controller;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dto.ReagentAdminLoginParam;
import jp.co.nss.hrm.backend.api.dto.ReagentAdminParam;
import jp.co.nss.hrm.backend.api.dto.UpdateAdminPasswordParam;
import jp.co.nss.hrm.backend.api.service.ReagentAdminService;
import jp.co.nss.hrm.backend.api.service.ReagentRoleService;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.mapper.ReagentAdminMapper;
import jp.co.nss.hrm.backend.model.ReagentAdmin;
import jp.co.nss.hrm.backend.model.ReagentRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "ReagentAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class ReagentAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private ReagentAdminService adminService;
    @Autowired
    private ReagentRoleService roleService;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private ReagentAdminMapper adminMapper;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ReagentAdmin> register(@Validated @RequestBody ReagentAdminParam umsAdminParam) {
        ReagentAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed("用户名已存在！");
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody ReagentAdminLoginParam umsAdminLoginParam) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        ReagentAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        data.put("nickname", umsAdmin.getTrueName());
        List<ReagentRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(ReagentRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
            Long roleID = roleList.get(0).getId();
            data.put("roleID", roleID);
        }
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                     @RequestParam(value = "username", required = false) String username,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentAdmin> adminList = adminService.list(keyword, username, pageSize, pageNum);
        return CommonResult.success(adminList);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentAdmin> getItem(@PathVariable Long id) {
        ReagentAdmin admin = adminService.getItem(id);
        return CommonResult.success(admin);
    }

    @ApiOperation("获取指定用户真实姓名")
    @RequestMapping(value = "/getTrueName/{username}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentAdmin>> getTrueName(@PathVariable String username) {
        List<ReagentAdmin> admin = adminService.getTrueName(username);
        return CommonResult.success(admin);
    }

    @OperationLogAnnotation(operaModule = "用户管理", operaDesc = "修改用户")
    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentAdmin admin) {
        int count = adminService.update(id, admin, null);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@Validated @RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @OperationLogAnnotation(operaModule = "用户管理", operaDesc = "删除用户")
    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id, @RequestParam(value = "username") String username) {
        ReagentAdmin admin = adminMapper.selectByPrimaryKey(id);
        Long roleId = adminRoleRelationDao.selectByAdmin(id);

        //不是超管，不是自身
        if (roleId != 1 && !admin.getUsername().equals(username)) {
            int count = adminService.delete(id);
            return CommonResult.success(count);
        }
        if (roleId == 1) return CommonResult.failed("不可删除超级管理员用户!");
        if (admin.getUsername().equals(username)) return CommonResult.failed("不可删除自身!");

        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "用户管理", operaDesc = "修改状态")
    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id,
                                     @RequestParam(value = "status") Integer status,
                                     @RequestParam(value = "username") String username) {
        ReagentAdmin umsAdmin = new ReagentAdmin();
        umsAdmin.setStatus(status);
        int count = adminService.update(id, umsAdmin, username);
        if (count == 1) {
            return CommonResult.success(count);
        } else if (count == 2) {
            return CommonResult.failed("不可禁用超级管理员用户");
        } else if (count == 3) {
            return CommonResult.failed("不可禁用管理员用户");
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "用户管理", operaDesc = "分配角色")
    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRole>> getRoleList(@PathVariable Long adminId) {
        List<ReagentRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("检查指定科室是否存在某用户")
    @RequestMapping(value = "/checkUserFromBranch", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Integer> checkUserFromBranch(@RequestParam(value = "usernameCurrent") String usernameCurrent,
                                                     @RequestParam(value = "usernameTarget") String usernameTarget) {
        int res = adminService.checkUserFromBranch(usernameCurrent, usernameTarget);
        return CommonResult.success(res);
    }

    /**
     * 获取同属当前用户科室的试剂操作员列表
     */
    @ApiOperation("获取同属当前用户科室的试剂操作员列表")
    @RequestMapping(value="/operator/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentAdmin>> getOperatorList(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        
        String username = principal.getName();
        ReagentAdmin umsAdmin = adminService.getAdminByUsername(username);
        String branch = umsAdmin.getBranch();

        List<ReagentAdmin> arrOperator = adminService.getOperatorList(branch);

        return CommonResult.success(arrOperator);
    }

}
