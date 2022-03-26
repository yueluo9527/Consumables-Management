package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.api.service.ReagentAdminService;
import jp.co.nss.hrm.backend.api.service.ReagentStockDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentAdmin;
import jp.co.nss.hrm.backend.model.ReagentStock;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * 中心库存详细信息管理Controller
 * Created by macro on 2021/3/9.
 */
@Controller
@Api(tags = "ReagentStockDetailController", description = "库存详细信息管理")
@RequestMapping("/stockDetail")
public class ReagentStockDetailController {
    @Autowired
    private ReagentStockDetailService stockDetailService;
    @Autowired
    private ReagentAdminService adminService;

    @ApiOperation("添加库存详细信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentStockDetail stockDetail) {
        int count = stockDetailService.create(stockDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "在库管理", operaDesc = "修改详情")
    @ApiOperation("修改库存详细信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentStockDetail stockDetail) {
        int count = stockDetailService.update(id, stockDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "在库管理", operaDesc = "删除详情")
    @ApiOperation("删除库存详细信息")
    @RequestMapping(value = "/delete/{allocId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long allocId) {
        int count = stockDetailService.delete(allocId);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("判断试剂信息是否在库")
    @RequestMapping(value = "/isInStock/{code}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult isInStock(@PathVariable Long code) {
        int flag = Integer.parseInt(stockDetailService.isInStock(code));
        return CommonResult.success(flag);
    }

    @ApiOperation("判断供货商是否被禁")
    @RequestMapping(value = "/isSupInStock/{shortName}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult isSupInStock(@PathVariable String shortName) {
        int flag = Integer.parseInt(stockDetailService.isSupInStock(shortName));
        return CommonResult.success(flag);
    }

    @ApiOperation("获取所有库存详细信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentStockDetail>> listAll() {
        List<ReagentStockDetail> stockList = stockDetailService.list();
        return CommonResult.success(stockList);
    }

    @ApiOperation("分页获取库存详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStockDetail>> list(@RequestBody ReagentStockDetailReq stockDetailReq) {
        List<ReagentStockDetail> stockDetailList = stockDetailService.list(stockDetailReq);
        return CommonResult.success(CommonPage.restPage(stockDetailList));
    }

    @ApiOperation("检索获取库存详细信息列表")
    @RequestMapping(value = "/fetchSearch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStockDetail>> fetchSearch(@RequestBody ReagentStockDetailReq stockDetailReq) {
        List<ReagentStockDetail> stockDetailList = stockDetailService.fetchSearch(stockDetailReq);
        return CommonResult.success(CommonPage.restPage(stockDetailList));
    }

    @ApiOperation("分页获取库损详细信息列表")
    @RequestMapping(value = "/lossList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStockDetail>> lossList(@RequestParam(value = "reagentId", required = false) String reagentId,
                                                                 @RequestParam(value = "reagentStatus", required = false) String reagentStatus,
                                                                 @RequestParam(value = "username", required = false) String username,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentStockDetail> stockDetailList = stockDetailService.lossList(reagentId, reagentStatus, username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(stockDetailList));
    }

    @OperationLogAnnotation(operaModule = "在库管理", operaDesc = "库损")
    @ApiOperation("给试剂分配库损类型")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@RequestParam("qrcode") String qrcode,
                                     @RequestParam("lossId") String lossId) {
        int count = stockDetailService.updateStatus(qrcode, lossId);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "在库管理-pda", operaDesc = "批量更新库损")
    @ApiOperation("PDA批量更新库损状态")
    @RequestMapping(value = "/updateStatusList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatusList(@RequestBody ReagentStockReqPost stockLoss) {
        int count = stockDetailService.updateStatusList(stockLoss);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * pda 扫码获取单个试剂
     *
     * @param qrCode   String 二维码
     * @param username String
     * @param isLater  String 是否需要查找比当前试剂更早过期的试剂，1-需要
     * @param isMore   String 是否需要查找非正常状态的试剂，1-需要
     * @param countSameStore String 是否需要计算科室库中同类型的试剂数量，1-需要
     * @return CommonResult
     */
    @ApiOperation("项目检索")
    @GetMapping("/pda")
    @ResponseBody
    public CommonResult findItem(@RequestParam("qrCode") String qrCode,
                                 @RequestParam(value = "username") String username,
                                 @RequestParam(value = "isLater", required = false) String isLater,
                                 @RequestParam(value = "isMore", required = false) String isMore,
                                 @RequestParam(value = "countSameStore", required = false) String countSameStore) {
        GetReagentItem res = stockDetailService.findReagentItem(qrCode, username, isMore);
        ReagentItem item = res.getData();

        // 状态或权限问题导致扫码查询失败
        if (res.getCode() == 0) {
            return CommonResult.failed(201, res.getMsg());
        }

        // 是否需要检查更早过期的试剂
        if (item != null && isLater != null && isLater.equals("1")) {
            // 保留 list，预防需求的变动
            List<ReagentItem> result = stockDetailService.getReagentEarlier(item, username);

            item.setEarlierNum(result.size());
        }

        // 计算科室库中相同类型试剂的数量
        if (item != null && "1".equals(countSameStore)) {
            long reagentNumber = stockDetailService.getDeptStockNumberByReagentId(item.getReagentId());
            item.setReagentNumber(reagentNumber);
        }

        return CommonResult.success(item);
    }

    @OperationLogAnnotation(operaModule = "在库管理-pda", operaDesc = "试剂终结")
    @ApiOperation("试剂终结")
    @RequestMapping(value = "/pda/endReagent", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult endReagent(@RequestBody ReagentStockReqPost stockEnd) {
        int count = stockDetailService.endReagent(stockEnd);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("库损报表")
    @RequestMapping(value = "/countLoss", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStatus>> countLoss(@RequestParam(value = "username", required = false) String username,
                                                             @RequestParam(value = "startTime", required = false) String startTime,
                                                             @RequestParam(value = "endTime", required = false) String endTime,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentStatus> lossList = stockDetailService.lossCount(username, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(lossList));
    }

    @ApiOperation("出入库报表")
    @RequestMapping(value = "/countOutIn", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentStatus>> countOutIn(@RequestParam(value = "username", required = false) String username,
                                                              @RequestParam(value = "supplier", required = false) String supplier,
                                                              @RequestParam(value = "startTime", required = false) String startTime,
                                                              @RequestParam(value = "endTime", required = false) String endTime,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentStatus> outInList = stockDetailService.countOutIn(username, supplier, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(outInList));
    }

    @ApiOperation("出入库报表")
    @RequestMapping(value = "/reagentOutIn", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentOutIn>> reagentOutIn(@RequestParam(value = "username", required = false) String username,
                                                             @RequestParam(value = "supplier", required = false) String supplier,
                                                             @RequestParam(value = "reagentName", required = false) String reagentName,
                                                             @RequestParam(value = "branchName", required = false) String branchName,
                                                             @RequestParam(value = "startTime", required = false) String startTime,
                                                             @RequestParam(value = "endTime", required = false) String endTime,
                                                             @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentOutIn> outInList = stockDetailService.reagentOutIn(username, supplier, reagentName, branchName, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(outInList);
    }

    @ApiOperation("库存总和报表")
    @RequestMapping(value = "/reagentOverall", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentStock>> reagentOverall(@RequestParam(value = "username", required = false) String username,
                                                               @RequestParam(value = "supplier", required = false) String supplier,
                                                               @RequestParam(value = "reagentName", required = false) String reagentName,
                                                               @RequestParam(value = "branchName", required = false) String branchName,
                                                               @RequestParam(value = "startTime", required = false) String startTime,
                                                               @RequestParam(value = "endTime", required = false) String endTime,
                                                               @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentStock> overallList = stockDetailService.reagentOverall(username, supplier, reagentName, branchName, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(overallList);
    }

    @ApiOperation("试剂使用记录报表")
    @RequestMapping(value = "/reagentUseLog", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentDetailReq>> reagentUseLog(@RequestParam(value = "username", required = false) String username,
                                                                  @RequestParam(value = "keyword", required = false) String keyword,
                                                                  @RequestParam(value = "reagentName", required = false) String reagentName,
                                                                  @RequestParam(value = "startTime", required = false) String startTime,
                                                                  @RequestParam(value = "endTime", required = false) String endTime,
                                                                  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentDetailReq> outInList = stockDetailService.reagentUseLog(username, keyword, reagentName, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(outInList);
    }

    @OperationLogAnnotation(operaModule = "在库管理", operaDesc = "修改开启有效期")
    @ApiOperation("更改单个试剂的开启有效期")
    @RequestMapping(value = "/update/effectiveOpenTime", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateEffectiveOpenTime(Principal principal,
                                                @RequestParam(value = "days", required = false) String days,
                                                @RequestParam(value = "qrcode", required = false) String qrcode) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();

        int res = stockDetailService.updateEffectiveOpenTime(username, days, qrcode);
        return CommonResult.success(res);
    }

    @ApiOperation("试剂开始上机使用")
    @RequestMapping(value = "/associateDevice", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> associateDevice(Principal principal,
                                                 @RequestParam(value = "qrcode") String qrcode,
                                                 @RequestParam(value = "deviceId") Long deviceId) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }

        String username = principal.getName();
        ReagentAdmin umsAdmin = adminService.getAdminByUsername(username);
        Long userId = umsAdmin.getId();


        int res = stockDetailService.updateDevice(qrcode, deviceId, userId);
        return CommonResult.success(res);
    }

    @ApiOperation("库损汇总信息列表")
    @RequestMapping(value = "/lossSummary", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentLossSummary>> lossSummary(@RequestParam(value = "keyword", required = false) String keyword,
                                                                    @RequestParam(value = "username", required = false) String username,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentLossSummary> lossSummaryList = stockDetailService.lossSummary(keyword, username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(lossSummaryList));
    }
}
