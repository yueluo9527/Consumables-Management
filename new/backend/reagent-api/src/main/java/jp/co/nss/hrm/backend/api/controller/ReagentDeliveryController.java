package jp.co.nss.hrm.backend.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentDeliveryService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentOutBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库存信息管理Controller
 * Created by macro on 2021/3/8.
 */
@Controller
@Api(tags = "ReagentDeliveryController", description = "出库管理")
@RequestMapping("/delivery")
public class ReagentDeliveryController {
    @Autowired
    private ReagentDeliveryService deliveryService;

    @ApiOperation("添加库存信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentOutBill outBill) {
        int count = deliveryService.create(outBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改库存信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentOutBill outBill) {
        int count = deliveryService.update(id, outBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("删除指定库存信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = deliveryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("获取所有库存信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOutBill>> listAll() {
        List<ReagentOutBill> outBillList = deliveryService.list();
        return CommonResult.success(outBillList);
    }

    @ApiOperation("分页获取库存信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOutBill>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOutBill> outBillList = deliveryService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(outBillList));
    }


    @ApiOperation("获取指定库存信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentOutBill> getItem(@PathVariable Long id) {
        ReagentOutBill outBill = deliveryService.getItem(id);
        return CommonResult.success(outBill);
    }

    /*@ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStockCentre>> searchList(@RequestParam(value = "reagentId", required = false) Integer reagentId,
                                                                   @RequestParam(value = "reagentName", required = false) String reagentName,
                                                                   @RequestParam(value = "supplierName", required = false) String supplierName,
                                                                   @RequestParam(value = "factory", required = false) String factory,
                                                                   @RequestParam(value = "reagentStatus", required = false) String reagentStatus,
                                                                   @RequestParam(value = "reagentTemp", required = false) String reagentTemp,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentStockCentre> stockCentreList = stockCentreService.search(reagentId, reagentName,supplierName,factory,reagentStatus,reagentTemp);
        return CommonResult.success(CommonPage.restPage(stockCentreList));
    }*/
}

