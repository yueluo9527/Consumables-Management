package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.service.ReagentSupplierService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商信息管理Controller
 * Created by macro on 2021/3/3.
 */
@Controller
@Api(tags = "ReagentBranchController", description = "系统供应商管理")
@RequestMapping("/supplier")
public class ReagentSupplierController {
    @Autowired
    private ReagentSupplierService supplierService;

    @OperationLogAnnotation(operaModule = "供货商管理", operaDesc = "新增供货商")
    @ApiOperation("添加供应商信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentSupplier supplier) {
        int count = supplierService.create(supplier);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("已有同名供货商！");
    }

    @OperationLogAnnotation(operaModule = "供货商管理", operaDesc = "修改")
    @ApiOperation("修改供应商信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentSupplier supplier) {
        int count = supplierService.update(id, supplier);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("已有同名供货商！");
    }

    @OperationLogAnnotation(operaModule = "供货商管理", operaDesc = "删除")
    @ApiOperation("删除供应商")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = supplierService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有供应商")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentSupplier>> listAll() {
        List<ReagentSupplier> supplierList = supplierService.list();
        return CommonResult.success(supplierList);
    }

    @ApiOperation("分页获取供应商列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentSupplier>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentSupplier> supplierList = supplierService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(supplierList));
    }

    @ApiOperation("获取指定供应商信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentSupplier> getItem(@PathVariable Long id) {
        ReagentSupplier supplier = supplierService.getItem(id);
        return CommonResult.success(supplier);
    }

    @OperationLogAnnotation(operaModule = "供货商管理", operaDesc = "修改状态")
    @ApiOperation("修改供货商状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        ReagentSupplier supplier = new ReagentSupplier();
        supplier.setStatus(status);
        int count = supplierService.updateStatus(id, supplier);
        if (count > 0) {
            return CommonResult.success(count);
        } else
            return CommonResult.failed();
    }

}
