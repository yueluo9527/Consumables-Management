package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentEditBillPost;
import jp.co.nss.hrm.backend.api.dto.ReagentInBillDetail;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.api.service.ReagentInBillDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentInDetail;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库详细信息管理Controller
 * Created by macro on 2021/4/2.
 */
@Controller
@Api(tags = "ReagentInBillDetailController", description = "入库详情信息管理")
@RequestMapping("/inBillDetail")
public class ReagentInBillDetailController {
    @Autowired
    private ReagentInBillDetailService inBillDetailService;


    @ApiOperation("获取指定入库单详细信息")
    @RequestMapping(value = "/{billCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentInBillDetail>> getInBillDetail(@PathVariable String billCode) {
        List<ReagentInBillDetail> inBillDetailList = inBillDetailService.getInBillDetail(billCode);
        return CommonResult.success(inBillDetailList);
    }

    @ApiOperation("修改建码入库详细信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ReagentInDetail inDetail) {
        int count = inBillDetailService.update(inDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除入库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = inBillDetailService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定订单信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = inBillDetailService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentInBillDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentInBillDetail> inDetailList = inBillDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(inDetailList));
    }

    @ApiOperation("编辑状态分页获取详细信息列表")
    @RequestMapping(value = "/listInBill", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentInfo>> listInBill(@RequestParam(value = "keyword", required = false) String keyword,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentInfo> inDetailList = inBillDetailService.listInBill(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(inDetailList));
    }

    @ApiOperation("编辑入库信息")
    @RequestMapping(value = "/editInBill", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult editInBill(@RequestBody ReagentEditBillPost editBill) {
        int count = inBillDetailService.editInBill(editBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("提交入库信息")
    @RequestMapping(value = "/subInBill", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult subInBill(@RequestBody ReagentEditBillPost subInBill) {
        int count = inBillDetailService.subInBill(subInBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("出库报表")
    @RequestMapping(value = "/inSummary", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentInBillDetail>> inSummary(@RequestParam(value = "username", required = false) String username,
                                                               @RequestParam(value = "reagentName", required = false) String reagentName,
                                                               @RequestParam(value = "startTime", required = false) String startTime,
                                                               @RequestParam(value = "endTime", required = false) String endTime,
                                                               @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentInBillDetail> inSummaryList = inBillDetailService.inSummary(username,reagentName,startTime, endTime, pageSize, pageNum);
        return CommonResult.success(inSummaryList);
    }
}