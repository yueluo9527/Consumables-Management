package jp.co.nss.hrm.backend.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import jp.co.nss.hrm.backend.api.service.ReagentSearchService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;

import jp.co.nss.hrm.backend.model.ReagentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索Controller
 * Created by macro on 2021/3/20.
 */
@Controller
@Api(tags = "ReagentSearchController", description = "库存信息管理")
@RequestMapping("/search")
public class ReagentSearchController {
    @Autowired
    private ReagentSearchService searchService;

    @ApiOperation("添加库存信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentSearch search) {
        int count = searchService.create(search);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改库存信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentSearch search) {
        int count = searchService.update(id, search);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定库存信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = searchService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有库存信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentSearch>> listAll() {
        List<ReagentSearch> searchList = searchService.list();
        return CommonResult.success(searchList);
    }

    @ApiOperation("分页获取库存信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentSearch>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentSearch> searchList = searchService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(searchList));
    }

    @ApiOperation("查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentSearch>> searchList(@RequestParam(value = "key1", required = false) String key1,
                                                              @RequestParam(value = "key2", required = false) String key2,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentSearch> searchList = searchService.search(key1, key2);
        return CommonResult.success(CommonPage.restPage(searchList));
    }

    @ApiOperation("获取指定库存信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentSearch> getItem(@PathVariable Long id) {
        ReagentSearch search = searchService.getItem(id);
        return CommonResult.success(search);
    }
}

