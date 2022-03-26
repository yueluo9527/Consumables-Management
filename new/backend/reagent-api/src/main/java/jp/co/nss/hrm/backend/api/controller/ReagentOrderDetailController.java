package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.api.service.ReagentOrderDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单详细信息管理Controller
 * Created by macro on 2021/3/4.
 */
@Controller
@Api(tags = "ReagentOrderDetailController", description = "订单详细信息管理")
@RequestMapping("/orderDetail")
public class ReagentOrderDetailController {
    @Autowired
    private ReagentOrderDetailService orderDetailService;

    @ApiOperation("添加订单详细信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentOrderDetail orderdetail) {
        int count = orderDetailService.create(orderdetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改订单详细信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ReagentOrderDetail orderDetail) {
        int count = orderDetailService.update(orderDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("orderNos") List<String> orderNos) {
        int count = orderDetailService.delete(orderNos);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定订单信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = orderDetailService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有订单详细信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOrderDetail>> listAll() {
        List<ReagentOrderDetail> orderList = orderDetailService.list();
        return CommonResult.success(orderList);
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOrderDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOrderDetail> orderDetailList = orderDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderDetailList));
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/listPre", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentInfo>> listPre(@RequestParam(value = "keyword", required = false) String keyword) {
        List<ReagentInfo> orderDetailList = orderDetailService.listPre(keyword);
        return CommonResult.success(CommonPage.restPage(orderDetailList));
    }

    @ApiOperation("获取指定订单详细信息")
    @RequestMapping(value = "/{orderNo}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOrderDetail>> getItem(@PathVariable String orderNo) {
        List<ReagentOrderDetail> orderDetail = orderDetailService.getItem(orderNo);
        return CommonResult.success(orderDetail);
    }


}