package com.swiftcode.web.rest;

import com.swiftcode.domain.SapUser;
import com.swiftcode.service.SapUserService;
import com.swiftcode.service.dto.SapUserDTO;
import com.swiftcode.service.util.CommonResult;
import com.swiftcode.web.rest.vm.ManagedSapUserVm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("SAP USER 更新")
    @PostMapping("/updateUser")
    public CommonResult<SapUserDTO> updateSapUser(@RequestBody ManagedSapUserVm managedSapUserVm) {
        SapUserDTO sapUser = service.updateSapUser(managedSapUserVm);
        return CommonResult.success(sapUser, "更新成功");
    }

    @ApiOperation("SAP USER 查询")
    @GetMapping("/user/{userCode}")
    public CommonResult<SapUserDTO> findSapUser(@PathVariable String userCode) {
        SapUserDTO sapUser = service.findByUserCode(userCode);
        return CommonResult.success(sapUser, "查找成功");
    }

    @ApiOperation("SAP USER 列表")
    @GetMapping("/users")
    public CommonResult<List<SapUser>> findAll() {
        List<SapUser> list = service.findAll();
        return CommonResult.success(list);
    }

    @ApiOperation("SAP USER 是否存在")
    @GetMapping("/exist/{userCode}")
    public ResponseEntity<Map<String, Boolean>> isExist(@PathVariable String userCode) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("isExist", service.isExist(userCode));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
