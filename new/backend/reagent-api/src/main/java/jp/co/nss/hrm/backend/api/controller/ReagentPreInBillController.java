package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillPost;
import jp.co.nss.hrm.backend.api.service.ReagentPreInBillService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 预入库单信息管理Controller
 * Created by macro on 2021/3/11.
 */
@Controller
@Api(tags = "ReagentPreInBillController", description = "预入库信息管理")
@RequestMapping("/preInBill")
public class ReagentPreInBillController {
    @Autowired
    private ReagentPreInBillService preInBillService;

    @OperationLogAnnotation(operaModule = "随货同行单管理", operaDesc = "新增")
    @ApiOperation("添加预入库信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentPreInBillPost preInBill) {
        int count = preInBillService.create(preInBill);
        if (count > 0) {
            return CommonResult.success(count);
        } else
            return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "随货同行单管理", operaDesc = "删除")
    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = preInBillService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "随货同行单管理", operaDesc = "修改")
    @ApiOperation("修改预入库信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentPreInBill preInBill) {
        int count = preInBillService.update(id, preInBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有预入库信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentPreInBill>> listAll() {
        List<ReagentPreInBill> preInBillList = preInBillService.list();
        return CommonResult.success(preInBillList);
    }

    @ApiOperation("分页获取预入库信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentPreInBill>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                         @RequestParam(value = "username", required = false) String username,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentPreInBill> preInBillList = preInBillService.list(keyword, username, pageSize, pageNum);
        return CommonResult.success(preInBillList);
    }

    @ApiOperation("分页获取预入库信息列表")
    @RequestMapping(value = "/getPrintData", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentPreInBillMess>> getPrintData(@RequestParam(value = "keyword", required = false) String keyword,
                                                                       @RequestParam(value = "printType", required = false) String printType,
                                                                       @RequestParam(value = "billType", required = false) String billType,
                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentPreInBillMess> preInBillList = preInBillService.getPrintData(keyword, printType, billType, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInBillList));
    }

    @ApiOperation("获取指定预入库信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentPreInBill> getItem(@PathVariable Long id) {
        ReagentPreInBill preInBill = preInBillService.getItem(id);
        return CommonResult.success(preInBill);
    }

    @ApiOperation("通过供应商名称查询")
    @RequestMapping(value = "/listByBS", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentPreInBill>> listByBS(
            @RequestParam(value = "billStatus", required = false) String billStatus,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentPreInBill> preInBillList = preInBillService.searchByBS(billStatus, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInBillList));
    }

    @OperationLogAnnotation(operaModule = "随货同行单管理", operaDesc = "打印")
    @ApiOperation("获取需要打印的二维码")
    @RequestMapping(value = "/searchCodeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentItem>> searchCodeList(@RequestParam(value = "billCode", required = false) String billCode) {
        List<ReagentItem> codeList = preInBillService.searchCodeList(billCode);
        return CommonResult.success(codeList);
    }

    //@OperationLogAnnotation(operaModule = "随货同行单管理", operaDesc = "导入")
    @ApiOperation("导入质检报告单")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("inDetailId") String inDetailId, @RequestParam("cell") int cell) {
        String fileAddress = preInBillService.fileUpload(file, inDetailId, cell);
        return CommonResult.success(fileAddress);
    }

}