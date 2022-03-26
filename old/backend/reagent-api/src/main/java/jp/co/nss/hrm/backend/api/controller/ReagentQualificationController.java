package jp.co.nss.hrm.backend.api.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.service.ReagentQualificationService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentCopQualification;
import jp.co.nss.hrm.backend.model.ReagentProdQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 资质管理Controller
 * Created by macro on 2021/3/3.
 */
@Controller
@Api(tags = "ReagentQualificationController", description = "资质管理")
@RequestMapping("/qualification")
public class ReagentQualificationController {
    @Autowired
    private ReagentQualificationService qualificationService;

    @ApiOperation("获取公司资质")
    @RequestMapping(value = "/copList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentCopQualification>> copList(@RequestParam(value = "username", required = false) String username,
                                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentCopQualification> copList = qualificationService.copList(username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(copList));
    }

    @ApiOperation("分页获取产品资质列表")
    @RequestMapping(value = "/prodList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PageInfo<ReagentProdQualification>> prodList(@RequestParam(value = "username", required = false) String username,
                                                                     @RequestParam(value = "supplierShortName", required = false) String supplierShortName,
                                                                     @RequestParam(value = "reagentName", required = false) String reagentName,
                                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<ReagentProdQualification> qualificationList = qualificationService.prodList(username, supplierShortName, reagentName, pageSize, pageNum);
        return CommonResult.success(qualificationList);
    }

    @ApiOperation("导入产品资质报告单")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") long id, @RequestParam("cell") int cell, @RequestParam("flag") int flag) {
        String fileAddress = qualificationService.fileUpload(file, id, cell, flag);
        return CommonResult.success(fileAddress);
    }

    @ApiOperation("分页获取预入库信息列表")
    @RequestMapping(value = "/getReportPath", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> getReportPath(@RequestParam(value = "row", required = false) long row,
                                              @RequestParam(value = "column", required = false) int column,
                                              @RequestParam(value = "flag", required = false) int flag) {
        String reportPath = qualificationService.getReportPath(row, column, flag);
        return CommonResult.success(reportPath);
    }

}