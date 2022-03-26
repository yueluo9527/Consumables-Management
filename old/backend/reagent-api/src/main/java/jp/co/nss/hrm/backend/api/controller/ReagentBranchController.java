package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.service.ReagentBranchService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 科室管理Controller
 * Created by macro on 2021/2/17.
 */
@Controller
@Api(tags = "ReagentBranchController", description = "系统科室管理")
@RequestMapping("/branch")
public class ReagentBranchController {
    @Autowired
    private ReagentBranchService branchService;

    @OperationLogAnnotation(operaModule = "科室管理", operaDesc = "新增科室")
    @ApiOperation("添加科室")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentBranch branch) {
        int count = branchService.create(branch);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("科室已存在！");
    }

    @OperationLogAnnotation(operaModule = "科室管理", operaDesc = "修改科室")
    @ApiOperation("修改科室")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentBranch branch) {
        int count = branchService.update(id, branch);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "科室管理", operaDesc = "删除科室")
    @ApiOperation("删除指定科室信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = branchService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有科室")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentBranch>> listAll() {
        List<ReagentBranch> branchList = branchService.list();
        return CommonResult.success(branchList);
    }

    @ApiOperation("分页获取科室列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentBranch>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentBranch> branchList = branchService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(branchList));
    }

    @ApiOperation("根据名称查询科室")
    @RequestMapping(value = "/listBranch/{branchName}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentBranch>> getAllByBranchName(@PathVariable String branchName) {
        List<ReagentBranch> branchList = branchService.getAllByBranchName(branchName);
        return CommonResult.success(branchList);
    }

    @ApiOperation("获取指定科室信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentBranch> getItem(@PathVariable Long id) {
        ReagentBranch branch = branchService.getItem(id);
        return CommonResult.success(branch);
    }

}