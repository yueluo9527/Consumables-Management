package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentRefundItemService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 退货详细信息管理Controller
 * Created by macro on 2021/3/25.
 */
@Controller
@Api(tags = "ReagentRefundItemController", description = "退货详细信息管理")
@RequestMapping("/refundItem")
public class ReagentRefundItemController {
    @Autowired
    private ReagentRefundItemService refundItemService;

    @ApiOperation("获取退货详细详细信息")
    @RequestMapping(value = "/refundItemByRDI/{refundDetailId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefundDetailItem>> getItemByRDI(@PathVariable String refundDetailId) {
        List<ReagentRefundDetailItem> refundItemList = refundItemService.getItemByRDI(refundDetailId);
        return CommonResult.success(refundItemList);
    }


    @ApiOperation("获取退货详细详细信息")
    @RequestMapping(value = "/getItemByRC/{refundCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefundDetailItem>> getItemByRC(@PathVariable String refundCode) {
        List<ReagentRefundDetailItem> refundItemList = refundItemService.getItemByRC(refundCode);
        return CommonResult.success(refundItemList);
    }

    @ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefundDetailItem>> searchList(@RequestParam(value = "refundCode", required = false) String refundCode,
                                                                        @RequestParam(value = "refundDetailId", required = false) String refundDetailId,
                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentRefundDetailItem> refundItemList = refundItemService.search(refundCode, refundDetailId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundItemList));
    }

    @ApiOperation("删除退货详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("refundCodes") List<String> refundCodes) {
        int count = refundItemService.delete(refundCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取退货详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefundDetailItem>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentRefundDetailItem> refundDetailItemList = refundItemService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundDetailItemList));
    }

}