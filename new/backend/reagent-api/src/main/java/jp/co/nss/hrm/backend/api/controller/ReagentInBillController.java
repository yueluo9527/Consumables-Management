package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.api.service.ReagentCollectService;
import jp.co.nss.hrm.backend.api.service.ReagentInBillService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentInBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * 入库管理Controller
 * Created by macro on 2021/4/2.
 */
@Controller
@Api(tags = "ReagentInBillController", description = "入库管理")
@RequestMapping("/inBill")
//@RequestMapping("/api/inbills")
public class ReagentInBillController {

    @Autowired
    private ReagentInBillService inBillService;
    @Autowired
    private ReagentCollectService collectService;

    @OperationLogAnnotation(operaModule = "入库管理-pda", operaDesc = "新增")
    @ApiOperation("入库登录")
    @PostMapping("/pda")
    @ResponseBody
    public CommonResult<String> createInBillPda(@RequestBody ReagentInBillPDAReq inBillReq) {
        try {
            String result = inBillService.createInBillPda(inBillReq);
            return CommonResult.success(result);
        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    @OperationLogAnnotation(operaModule = "入库管理-pda-一键入库", operaDesc = "新增")
    @ApiOperation("入库登录")
    @PostMapping("/pda/oneKey")
    @ResponseBody
    public CommonResult<Integer> createInBillPdaByOneKey(@RequestBody ReagentInBillPDAReq req, Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();

        try {
            Integer result = inBillService.createInBillPdaByOneKey(req, username);
            if (result == 1) return CommonResult.success(result);
            else return CommonResult.failed("一键入库失败");
        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    @OperationLogAnnotation(operaModule = "移库管理-pda-一键移库", operaDesc = "新增")
    @ApiOperation("移库登录")
    @PostMapping("/pda/oneKeyCollect")
    @ResponseBody
    public CommonResult<Integer> createCollectPdaByOneKey(@RequestBody ReagentCollectPDAReq req, Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();

        try {
            Integer result = collectService.createCollectPdaByOneKey(req, username);
            if (result == 1) return CommonResult.success(result);
            else return CommonResult.failed("一键移库失败");
        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    @ApiOperation("项目检索")
    @GetMapping("/pda/{qrCode}")
    @ResponseBody
    public CommonResult<ReagentItem> findItem(@PathVariable("qrCode") String qrCode) {
        ReagentItem item = inBillService.findReagentItem(qrCode);
        return CommonResult.success(item);
    }

    @OperationLogAnnotation(operaModule = "入库管理-web", operaDesc = "新增")
    @ApiOperation("添加入库信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentInBillPost inBill) {
        int count = inBillService.create(inBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据入库单类型查询入库单")
    @RequestMapping(value = "/inList/{billType}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentInBill>> getAllByBillType(@PathVariable String billType) {
        List<ReagentInBill> inBillList = inBillService.getAllByBillType(billType);
        return CommonResult.success(inBillList);
    }

    @OperationLogAnnotation(operaModule = "入库管理", operaDesc = "修改入库单")
    @ApiOperation("修改入库单信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentInBill inBill) {
        int count = inBillService.update(id, inBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "入库管理", operaDesc = "修改状态")
    @ApiOperation("根据入库单号修改入库单状态")
    @RequestMapping(value = "/updateByBC/{billCode}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateByBC(@PathVariable String billCode, @RequestBody ReagentInBill inBill) {
        int count = inBillService.updateByBC(billCode, inBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "入库管理", operaDesc = "删除")
    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = inBillService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @OperationLogAnnotation(operaModule = "入库管理", operaDesc = "根据单号删除")
    @ApiOperation("删除订单")
    @RequestMapping(value = "/deleteByBC", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteByBillCode(@RequestParam("billCode") String billCode) {
        int count = inBillService.deleteByBillCode(billCode);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取入库单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentInBillVm>> list(@RequestParam(value = "billType", required = false) String billType,
                                                          @RequestParam(value = "username", required = false) String username,
                                                          @RequestParam(value = "keyword", required = false) String keyword,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentInBillVm> inBillList = inBillService.searchList(billType, username, keyword, pageSize, pageNum);

        return CommonResult.success(CommonPage.restPage(inBillList));
    }

    @OperationLogAnnotation(operaModule = "入库管理", operaDesc = "打印")
    @ApiOperation("获取需要打印的二维码")
    @RequestMapping(value = "/searchCodeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentItem>> searchCodeList(@RequestParam(value = "billCode", required = false) String billCode,
                                                          @RequestParam(value = "createType", required = false) String createType) {
        List<ReagentItem> codeList = inBillService.searchCodeList(billCode, createType);
        return CommonResult.success(codeList);
    }
}
