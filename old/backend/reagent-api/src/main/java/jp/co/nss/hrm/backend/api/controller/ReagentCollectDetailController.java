package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentCollectDetailService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentCollectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 领用详细信息管理Controller
 * Created by macro on 2021/3/31.
 */
@Controller
@Api(tags = "ReagentCollectDetailController", description = "申领详细信息管理")
@RequestMapping("/collectDetail")
public class ReagentCollectDetailController {
    @Autowired
    private ReagentCollectDetailService collectDetailService;

    @ApiOperation("添加申领详细信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentCollectDetail collectDetail) {
        int count = collectDetailService.create(collectDetail);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改申领详细信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ReagentCollectDetail collectDetail) {
        int count = collectDetailService.update(collectDetail);
        return CommonResult.success(count);
    }

    @ApiOperation("删除申领详细")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("collectNos") List<String> collectNos) {
        int count = collectDetailService.delete(collectNos);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定申领详细信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = collectDetailService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有申领详细信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentCollectDetail>> listAll() {
        List<ReagentCollectDetail> collectList = collectDetailService.list();
        return CommonResult.success(collectList);
    }

    @ApiOperation("分页获取申领详细信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentCollectDetail>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentCollectDetail> collectDetailList = collectDetailService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(collectDetailList));
    }

    @ApiOperation("获取指定申领详细信息")
    @RequestMapping(value = "/{collectNo}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentCollectDetail>> getItem(@PathVariable String collectNo) {
        List<ReagentCollectDetail> collectDetail = collectDetailService.getItem(collectNo);
        return CommonResult.success(collectDetail);
    }


}