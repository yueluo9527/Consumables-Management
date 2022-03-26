package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.dto.ReagentCount;
import jp.co.nss.hrm.backend.api.dto.ReagentEcharts;
import jp.co.nss.hrm.backend.api.service.ReagentCountService;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库明细信息管理Controller
 * Created by macro on 2021/4/3.
 */
@Controller
@Api(tags = "ReagentInBillItemController", description = "入库明细信息管理")
@RequestMapping("/count")
public class ReagentCountController {
    @Autowired
    private ReagentCountService countService;

    @ApiOperation("获取饼图信息")
    @RequestMapping(value = "/chartPie", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentEcharts>> chartPie(@RequestParam(value = "username", required = false) String username) {
        List<ReagentEcharts> chartPieList = countService.chartPie(username);
        return CommonResult.success(chartPieList);
    }
    @ApiOperation("获取柱状图信息")
    @RequestMapping(value = "/chartBar", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentEcharts>> chartBar(@RequestParam(value = "username", required = false) String username) {
        List<ReagentEcharts> chartBarList = countService.chartBar(username);
        return CommonResult.success(chartBarList);
    }
    @ApiOperation("获取横向柱状图信息")
    @RequestMapping(value = "/chartBarTop", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentEcharts>> chartBarTop(@RequestParam(value = "username", required = false) String username) {
        List<ReagentEcharts> chartBarTopList = countService.chartBarTop(username);
        return CommonResult.success(chartBarTopList);
    }
    @ApiOperation("获取折线图信息")
    @RequestMapping(value = "/chartLine", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentEcharts>> chartLine(@RequestParam(value = "username", required = false) String username) {
        List<ReagentEcharts> chartLineList = countService.chartLine(username);
        return CommonResult.success(chartLineList);
    }
    @ApiOperation("获取首页统计数据")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentCount> getCount(@RequestParam(value = "username", required = false) String username) {
        ReagentCount countList = countService.getCount(username);
        return CommonResult.success(countList);
    }
    @ApiOperation("获取首页统计数据")
    @RequestMapping(value = "/homeCount", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentCount> getHomeCount(@RequestParam(value = "username", required = false) String username) {
        ReagentCount countList = countService.getHomeCount(username);
        return CommonResult.success(countList);
    }
    @ApiOperation("获取用户角色ID")
    @RequestMapping(value = "/getBranch/{username}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> getBranch(@PathVariable String username) {
        String branch = countService.getBranch(username);
        return CommonResult.success(branch);
    }

}