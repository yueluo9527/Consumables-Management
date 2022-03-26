package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.ReagentRefundPost;
import jp.co.nss.hrm.backend.api.dto.ReagentStockReqPost;
import jp.co.nss.hrm.backend.api.service.ReagentRefundService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentRefund;
import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 退货管理Controller
 * Created by macro on 2021/4/1.
 */
@Controller
@Api(tags = "ReagentRefundController", description = "退货管理")
@RequestMapping("/refund")
public class ReagentRefundController {
    @Autowired
    private ReagentRefundService refundService;

    @OperationLogAnnotation(operaModule = "退货管理", operaDesc = "新增")
    @ApiOperation("添加退货申请信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentRefundPost refund) {
        int count = refundService.create(refund);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "退货管理-pda", operaDesc = "新增")
    @ApiOperation("pda添加退货申请信息")
    @RequestMapping(value = "/pda/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBill(@RequestBody ReagentStockReqPost stockRefund) {
        int count = refundService.createBill(stockRefund);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据申请单类型查询申请单")
    @RequestMapping(value = "/inList/{refundType}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefund>> getAllByRefundType(@PathVariable String refundType) {
        List<ReagentRefund> refundList = refundService.getAllByRefundType(refundType);
        return CommonResult.success(refundList);
    }

    @OperationLogAnnotation(operaModule = "退货管理", operaDesc = "修改")
    @ApiOperation("修改领用申请单信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentRefund refund) {
        int count = refundService.update(id, refund);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "退货管理", operaDesc = "删除")
    @ApiOperation("删除领用申请单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = refundService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "退货管理", operaDesc = "根据单号删除")
    @ApiOperation("删除订单")
    @RequestMapping(value = "/deleteByRFC", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteByRefundCode(@RequestParam("refundCode") String refundCode) {

        int count = refundService.deleteByRefundCode(refundCode);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有领用信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentRefund>> listAll() {
        List<ReagentRefund> refundList = refundService.list();
        return CommonResult.success(refundList);
    }


    @ApiOperation("分页获取退货列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefund>> list(@RequestParam(value = "refundType", required = false) String refundType,
                                                        @RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "username", required = false) String username,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentRefund> refundList = refundService.list(refundType, keyword, username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundList));
    }

    @ApiOperation("获取指定领用申请单信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentRefund> getItem(@PathVariable Long id) {
        ReagentRefund refund = refundService.getItem(id);
        return CommonResult.success(refund);
    }

    @ApiOperation("根据起止日期获取指定退货单信息")
    @RequestMapping(value = "/searchByDate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefund>> searchByDate(@RequestParam(value = "startTime", required = false) String startTime,
                                                                @RequestParam(value = "endTime", required = false) String endTime,
                                                                @RequestParam(value = "refundType", required = false) String refundType,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        /*System.out.println(startTime);
        System.out.println(endTime);*/
        List<ReagentRefund> refundDetail = refundService.searchByDate(startTime, endTime, refundType, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundDetail));
    }

    @ApiOperation("分页获取退货列表")
    @RequestMapping(value = "/countRefund", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentRefundDetail>> countRefund(@RequestParam(value = "refundType", required = false) String refundType,
                                                                     @RequestParam(value = "username", required = false) String username,
                                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentRefundDetail> refundDetailList = refundService.countRefund(refundType, username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundDetailList));
    }
}
