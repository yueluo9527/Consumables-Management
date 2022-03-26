package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.AdminUserDetails;
import jp.co.nss.hrm.backend.api.dto.ReagentOutBillReq;
import jp.co.nss.hrm.backend.api.service.ReagentOutBillService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentOutBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 出库管理Controller
 * Created by macro on 2021/3/22.
 */
@Controller
@Api(tags = "ReagentOutBillController", description = "出库管理")
@RequestMapping("/outBill")
public class ReagentOutBillController {
    @Autowired
    private ReagentOutBillService outBillService;

    @ApiOperation("根据名称查询科室")
    @RequestMapping(value = "/outList/{billType}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentOutBill>> getAllByBillType(@PathVariable String billType) {
        List<ReagentOutBill> outBillList = outBillService.getAllByBillType(billType);
        return CommonResult.success(outBillList);
    }

    @OperationLogAnnotation(operaModule = "出库管理-pda", operaDesc = "新增")
    @ApiOperation("pda出库")
    @RequestMapping(value = "/pda/outItem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult pdaOutBill(@RequestBody ReagentOutBillReq outBill) {
        int count = outBillService.createOutDoc(outBill);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页获取出库列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOutBill>> list(@RequestParam(value = "billType", required = false) String billType,
                                                         @RequestParam(value = "keyword", required = false) String keyword,
                                                         @RequestParam(value = "username", required = false) String username,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOutBill> outBillList = outBillService.list(billType, keyword, username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(outBillList));
    }

    @OperationLogAnnotation(operaModule = "出库管理", operaDesc = "删除")
    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = outBillService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("出库登录")
    @PostMapping("/")
    @ResponseBody
    public CommonResult<Integer> createOutBill(@RequestBody ReagentOutBillReq req,
                                               @AuthenticationPrincipal AdminUserDetails userDetail) {
        try {
            int count = outBillService.createOutBill(req);
            return CommonResult.success(count);

        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

}
