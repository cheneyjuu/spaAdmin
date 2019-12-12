package com.swiftcode.web.rest;

import com.swiftcode.service.BottleneckService;
import com.swiftcode.service.dto.BottleneckDTO;
import com.swiftcode.service.util.CommonResult;
import com.swiftcode.web.rest.errors.SearchUserDevicesException;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api/sap")
public class BottleneckResource {
    private BottleneckService service;

    public BottleneckResource(BottleneckService service) {
        this.service = service;
    }

    @GetMapping("/bottleneck")
    public CommonResult<Void> findUserDevices(@RequestParam("userCode") String userCode) {
        try {
            service.findUserDevices(userCode);
            return CommonResult.success(null);
        } catch (URISyntaxException e) {
            throw new SearchUserDevicesException();
        }
    }

    @PostMapping("/bottleneck")
    public CommonResult<Void> importDevice(@RequestBody BottleneckDTO dto) {
        try {
            service.importDevice(dto);
            return CommonResult.success(null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException();
        }
    }
}
