package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentOperationLogService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 操作日志管理Controller
 * Created by macro on 2021/3/3.
 */
@Controller
@Api(tags = "ReagentOperationLogController", description = "操作日志管理")
@RequestMapping("/operationLog")
public class ReagentOperationLogController {
    @Autowired
    private ReagentOperationLogService operationLogService;

    @ApiOperation("分页获取试剂信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentOperationLog>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentOperationLog> operationLogList = operationLogService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(operationLogList));
    }

    @ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentOperationLog>> searchList(@RequestParam(value = "module", required = false) String module,
                                                                  @RequestParam(value = "userName", required = false) String userName,
                                                                  @RequestParam(value = "result", required = false) String result,
                                                                  @RequestParam(value = "username", required = false) String username,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentOperationLog> operationLogList = operationLogService.search(module, userName, result, username, pageSize, pageNum);
        return CommonResult.success(operationLogList);
    }

}