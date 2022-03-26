package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentOutDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 出库详细信息管理Controller
 * Created by macro on 2021/3/22.
 */
@Controller
@Api(tags = "ReagentOutDetailController", description = "出库详细信息管理")
@RequestMapping("/outDetail")
public class ReagentOutDetailController {
    @Autowired
    private ReagentOutDetailService outDetailService;

    @ApiOperation("获取出库信息")
    @RequestMapping(value = "/{billCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOutDetail>> getItem(@PathVariable String billCode) {
        List<ReagentOutDetail> outDetailList = outDetailService.getItem(billCode);
        return CommonResult.success(outDetailList);
    }

    @ApiOperation("删除出库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = outDetailService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOutDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOutDetail> outDetailList = outDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(outDetailList));
    }

    @ApiOperation("出库报表")
    @RequestMapping(value = "/outSummary", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentOutDetail>> outSummary(@RequestParam(value = "username", required = false) String username,
                                                               @RequestParam(value = "reagentName", required = false) String reagentName,
                                                               @RequestParam(value = "startTime", required = false) String startTime,
                                                               @RequestParam(value = "endTime", required = false) String endTime,
                                                               @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentOutDetail> outSummaryList = outDetailService.outSummary(username, reagentName, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(outSummaryList);
    }


}