package com.swiftcode.web.rest;

import com.swiftcode.domain.SapUser;
import com.swiftcode.service.SapUserService;
import com.swiftcode.service.dto.SapUserDTO;
import com.swiftcode.service.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api/sap")
@Api(tags = "SAP用户管理")
public class SapUserResource {
    private SapUserService service;

    public SapUserResource(SapUserService service) {
        this.service = service;
    }

    @ApiOperation("SAP USER 注册")
    @PostMapping("/users")
    public CommonResult<SapUserDTO> addSapUser(@RequestBody SapUserDTO dto) {
        SapUserDTO sapUser = service.addSapUser(dto);
        return CommonResult.success(sapUser, "添加成功");
    }

    @ApiOperation("SAP USER 列表")
    @GetMapping("/users")
    public CommonResult<List<SapUser>> findAll() {
        List<SapUser> list = service.findAll();
        return CommonResult.success(list);
    }

    @PutMapping("/users/{userCode}/reset")
    public CommonResult<Void> resetPassword(@PathVariable("userCode") String userCode) {
        service.resetPassword(userCode);
        return CommonResult.success(null, "密码重置成功");
    }
}
