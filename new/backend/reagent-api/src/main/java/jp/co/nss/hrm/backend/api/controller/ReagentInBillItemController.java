package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentInBillItemService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentInDetailItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库明细信息管理Controller
 * Created by macro on 2021/4/3.
 */
@Controller
@Api(tags = "ReagentInBillItemController", description = "入库明细信息管理")
@RequestMapping("/inBillItem")
public class ReagentInBillItemController {
    @Autowired
    private ReagentInBillItemService inBillItemService;


    @ApiOperation("获取指定入库详细信息")
    @RequestMapping(value = "/{inDetailId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentInDetailItem>> getInBillItem(@PathVariable String inDetailId) {
        List<ReagentInDetailItem> inItemList = inBillItemService.getInBillItem(inDetailId);
        return CommonResult.success(inItemList);
    }

    @ApiOperation("删除入库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = inBillItemService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentInDetailItem>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentInDetailItem> inDetailList = inBillItemService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(inDetailList));
    }

}