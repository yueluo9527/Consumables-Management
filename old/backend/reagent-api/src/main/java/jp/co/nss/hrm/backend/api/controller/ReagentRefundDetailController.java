package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentRefundDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 领用详细信息管理Controller
 * Created by macro on 2021/3/31.
 */
@Controller
@Api(tags = "ReagentRefundDetailController", description = "退货详情信息管理")
@RequestMapping("/refundDetail")
public class ReagentRefundDetailController {
    @Autowired
    private ReagentRefundDetailService refundDetailService;

    @ApiOperation("添加退货详情信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentRefundDetail refundDetail) {
        int count = refundDetailService.create(refundDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改退货详情信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ReagentRefundDetail refundDetail) {
        int count = refundDetailService.update(refundDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除退货详情")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("refundCodes") List<String> refundCodes) {
        int count = refundDetailService.delete(refundCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定退货详情信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = refundDetailService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有退货详情信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefundDetail>> listAll() {
        List<ReagentRefundDetail> refundList = refundDetailService.list();
        return CommonResult.success(refundList);
    }

    @ApiOperation("分页获取退货详情信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefundDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentRefundDetail> refundDetailList = refundDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundDetailList));
    }

    @ApiOperation("获取指定退货详情信息")
    @RequestMapping(value = "/{refundCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefundDetail>> getItem(@PathVariable String refundCode) {
        List<ReagentRefundDetail> refundDetail = refundDetailService.getItem(refundCode);
        return CommonResult.success(refundDetail);
    }

}