package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.service.ReagentDeviceService;
import jp.co.nss.hrm.backend.common.api.CommonPage;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import jp.co.nss.hrm.backend.model.ReagentBranch;
import jp.co.nss.hrm.backend.model.ReagentDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备管理Controller
 * Created by macro on 2021/2/17.
 */
@Controller
@Api(tags = "ReagentDeviceController", description = "系统设备管理")
@RequestMapping("/device")
public class ReagentDeviceController {
    @Autowired
    private ReagentDeviceService deviceService;

    @OperationLogAnnotation(operaModule = "设备管理", operaDesc = "新增设备")
    @ApiOperation("添加设备")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ReagentDevice device) {
        int count = deviceService.create(device);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("设备编号已存在！");
    }

    @OperationLogAnnotation(operaModule = "设备管理", operaDesc = "修改设备")
    @ApiOperation("修改设备")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ReagentDevice device) {
        int count = deviceService.update(id, device);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("设备编号已存在！");
    }

    @OperationLogAnnotation(operaModule = "设备管理", operaDesc = "删除设备")
    @ApiOperation("删除指定设备信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = deviceService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有设备")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentDevice>> listAll() {
        List<ReagentDevice> deviceList = deviceService.list();
        return CommonResult.success(deviceList);
    }

    @ApiOperation("根据名称查询设备")
    @RequestMapping(value = "/getDeviceList/{username}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentDevice>> getDeviceList(@PathVariable String username) {
        List<ReagentDevice> deviceList = deviceService.getDeviceList(username);
        return CommonResult.success(deviceList);
    }

    @ApiOperation("分页获取设备列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ReagentDevice>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "createBy", required = false) String createBy,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ReagentDevice> deviceList = deviceService.list(keyword, createBy, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceList));
    }

    @ApiOperation("根据名称查询设备")
    @RequestMapping(value = "/listDevice/{deviceName}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ReagentDevice>> getAllByDeviceName(@PathVariable String deviceName) {
        List<ReagentDevice> deviceList = deviceService.getAllByDeviceName(deviceName);
        return CommonResult.success(deviceList);

    }

    @ApiOperation("获取指定设备信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentDevice> getItem(@PathVariable Long id) {
        ReagentDevice device = deviceService.getItem(id);
        return CommonResult.success(device);
    }

    @ApiOperation("根据二维码获取设备信息")
    @RequestMapping(value = "/getByQrcode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ReagentDevice> getItemByQrcode(@RequestParam(value = "qrcode") String qrcode) {
        ReagentDevice device = deviceService.getItemByQrcode(qrcode);

        return CommonResult.success(device);
    }

    @OperationLogAnnotation(operaModule = "设备管理", operaDesc = "修改状态")
    @ApiOperation("修改供货商状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "deviceStatus") Byte deviceStatus) {
        ReagentDevice device = new ReagentDevice();
        device.setDeviceStatus(deviceStatus);
        int count = deviceService.updateStatus(id, device);
        if (count > 0) {
            return CommonResult.success(count);
        } else
            return CommonResult.failed();
    }

}
