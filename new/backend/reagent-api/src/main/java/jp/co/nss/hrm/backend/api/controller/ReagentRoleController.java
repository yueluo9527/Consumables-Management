package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.service.ReagentRoleService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentMenu;
import jp.co.nss.hrm.backend.model.ReagentResource;
import jp.co.nss.hrm.backend.model.ReagentRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色管理Controller
 * Created by macro on 2018/9/30.
 */
@Controller
@Api(tags = "ReagentRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class ReagentRoleController {
    @Autowired
    private ReagentRoleService roleService;

    @OperationLogAnnotation(operaModule = "角色管理", operaDesc = "新增")
    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentRole role) {
        int count = roleService.create(role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "角色管理", operaDesc = "修改")
    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "角色管理", operaDesc = "批量删除")
    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = roleService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else if (count == 0) {
            return CommonResult.failed("不可删除超级管理员角色！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRole>> listAll() {
        List<ReagentRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                    @RequestParam(value = "username", required = false) String username,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentRole> roleList = roleService.list(keyword, username, pageSize, pageNum);
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据用户名获取角色列表")
    @RequestMapping(value = "/roleList/{adminName}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRole>> getRoleListByAdmin(@PathVariable String adminName) {
        List<ReagentRole> roleList = roleService.getRoleListByAdmin(adminName);
        return CommonResult.success(roleList);
    }

    @OperationLogAnnotation(operaModule = "角色管理", operaDesc = "修改状态")
    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        ReagentRole umsRole = new ReagentRole();

        umsRole.setStatus(status);
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        } else if (count == 0) {
            return CommonResult.failed("超级管理员不可禁用！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentMenu>> listMenu(@PathVariable Long roleId) {
        List<ReagentMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentResource>> listResource(@PathVariable Long roleId) {
        List<ReagentResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @OperationLogAnnotation(operaModule = "角色管理", operaDesc = "分配菜单")
    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }

}
