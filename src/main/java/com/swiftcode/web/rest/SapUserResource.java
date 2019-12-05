package com.swiftcode.web.rest;

import com.swiftcode.service.SapUserService;
import com.swiftcode.service.dto.SapUserDTO;
import com.swiftcode.service.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api/sap")
public class SapUserResource {
    private SapUserService service;

    public SapUserResource(SapUserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public CommonResult<SapUserDTO> addSapUser(@RequestBody SapUserDTO dto) {
        SapUserDTO sapUser = service.addSapUser(dto);
        return CommonResult.success(sapUser, "添加成功");
    }
}
