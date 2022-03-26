package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentOutItemService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 出库明细信息管理Controller
 * Created by macro on 2021/3/23.
 */
@Controller
@Api(tags = "ReagentOutItemController", description = "出库明细信息管理")
@RequestMapping("/outItem")
public class ReagentOutItemController {
    @Autowired
    private ReagentOutItemService outItemService;

    @ApiOperation("获取出库详细信息")
    @RequestMapping(value = "/{outDetailId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOutDetailItem>> getItem(@PathVariable String outDetailId) {
        List<ReagentOutDetailItem> outItemList = outItemService.getItem(outDetailId);
        return CommonResult.success(outItemList);
    }

    @ApiOperation("删除出库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = outItemService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOutDetailItem>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOutDetailItem> outDetailItemList = outItemService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(outDetailItemList));
    }

}