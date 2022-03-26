package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInItem;
import jp.co.nss.hrm.backend.api.service.ReagentPreInItemService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 预入库明细信息管理Controller
 * Created by macro on 2021/3/25.
 */
@Controller
@Api(tags = "ReagentPreInItemController", description = "预入库明细信息管理")
@RequestMapping("/preInItem")
public class ReagentPreInItemController {
    @Autowired
    private ReagentPreInItemService preInItemService;

    @ApiOperation("通过二维码查询试剂信息")
    @RequestMapping(value = "/getByQrCode")
    @ResponseBody
    public CommonResult<ReagentPreInItem> findPreItem(@RequestParam("qrCode") String qrCode) {
        ReagentPreInItem item = preInItemService.getPreItemByQrcode(qrCode);
        return CommonResult.success(item);
    }

    @ApiOperation("获取预入库详细信息")
    @RequestMapping(value = "/getItemByID/{inDetailId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentPreInDetailItem>> getItemByID(@PathVariable String inDetailId) {
        List<ReagentPreInDetailItem> preInItemList = preInItemService.getItemByID(inDetailId);
        return CommonResult.success(preInItemList);
    }

    @ApiOperation("获取预入库详细信息")
    @RequestMapping(value = "/getItemByBC/{billCode}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentPreInDetailItem>> getItemByBC(@PathVariable String billCode) {
        List<ReagentPreInDetailItem> preInItemList = preInItemService.getItemByBC(billCode);
        return CommonResult.success(preInItemList);
    }

    @ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentPreInDetailItem>> searchList(@RequestParam(value = "billCode", required = false) String billCode,
                                                                       @RequestParam(value = "inDetailId", required = false) String inDetailId,
                                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentPreInDetailItem> preInItemList = preInItemService.search(billCode, inDetailId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInItemList));
    }

    @ApiOperation("删除预入库单详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("billCodes") List<String> billCodes) {
        int count = preInItemService.delete(billCodes);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取订单详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentPreInDetailItem>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentPreInDetailItem> preInItemList = preInItemService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(preInItemList));
    }

}