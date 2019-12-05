package com.swiftcode.web.rest;

import com.swiftcode.service.DeviceService;
import com.swiftcode.service.dto.DeviceDTO;
import com.swiftcode.service.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api/sap")
@Api(tags = "设备管理")
public class DeviceResource {
    private DeviceService deviceService;

    public DeviceResource(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/devices")
    @ApiOperation("添加设备")
    public CommonResult<DeviceDTO> addDevice(@RequestBody DeviceDTO dto) {
        DeviceDTO device = deviceService.addDevice(dto);
        return CommonResult.success(device, "添加成功");
    }

    @GetMapping("/devices/{id}")
    @ApiOperation("查找设备列表")
    public CommonResult<DeviceDTO> findById(@PathVariable("id") Long id) {
        DeviceDTO dto = deviceService.findByDeviceId(id);
        return CommonResult.success(dto, "查找成功");
    }
}
