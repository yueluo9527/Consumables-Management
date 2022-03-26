package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentLoginLogReq;
import jp.co.nss.hrm.backend.api.service.ReagentLoginLogService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentAdminLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 登录日志管理Controller
 * Created by macro on 2021/3/3.
 */
@Controller
@Api(tags = "ReagentLoginLogController", description = "登录日志管理")
@RequestMapping("/loginLog")
public class ReagentLoginLogController {
    @Autowired
    private ReagentLoginLogService loginLogService;


    @ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentLoginLogReq>> searchList(@RequestParam(value = "adminId", required = false) Long adminId,
                                                                   @RequestParam(value = "ip", required = false) String ip,
                                                                   @RequestParam(value = "username", required = false) String username,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentLoginLogReq> loginLogList = loginLogService.search(adminId, ip, username, pageSize, pageNum);
        return CommonResult.success(loginLogList);
    }

}