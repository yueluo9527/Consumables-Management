package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.service.ReagentPreInDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentPreInDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 预入库详细信息管理Controller
 * Created by macro on 2021/3/11.
 */
@Controller
@Api(tags = "ReagentPreInDetailController", description = "预入库详细信息管理")
@RequestMapping("/preInDetail")
public class ReagentPreInDetailController {
    @Autowired
    private ReagentPreInDetailService preInDetailService;

    @ApiOperation("添加预入库详细信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentPreInDetail preInDetail) {
        int count = preInDetailService.create(preInDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改预入库详细信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentPreInDetail preInDetail) {
        int count = preInDetailService.update(id, preInDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除入库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = preInDetailService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有预入库详细信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentPreInDetail>> listAll() {
        List<ReagentPreInDetail> preInDetailList = preInDetailService.list();
        return CommonResult.success(preInDetailList);
    }

    @ApiOperation("分页获取预入库详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentPreInDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentPreInDetail> preInDetailList = preInDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInDetailList));
    }

    @ApiOperation("分页获取预入库详细信息列表")
    @RequestMapping(value = "/searchByBillCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentItem>> searchByBillCode(@RequestParam(value = "keyword", required = false) String keyword,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentItem> preInDetailList = preInDetailService.searchByBillCode(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInDetailList));
    }

    @ApiOperation("获取指定预入库详细信息")
    @RequestMapping(value = "/{billCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentPreInDetail>> getItem(@PathVariable String billCode) {
        List<ReagentPreInDetail> preInDetailList = preInDetailService.getItem(billCode);
        return CommonResult.success(preInDetailList);
    }

    @ApiOperation("获取报告单地址")
    @RequestMapping(value = "/getReportPath", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> getReportPath(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value = "column", required = false) int column) {
        String reportPath = preInDetailService.getReportPath(keyword, column);
        return CommonResult.success(reportPath);
    }

}