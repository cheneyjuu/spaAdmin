package com.swiftcode.web.rest;

import com.swiftcode.service.MalfunctionService;
import com.swiftcode.service.dto.MalfunctionDTO;
import com.swiftcode.service.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api")
public class MalfunctionResource {
    private MalfunctionService service;

    public MalfunctionResource(MalfunctionService service) {
        this.service = service;
    }

    @PostMapping("/malfunction")
    public CommonResult<MalfunctionDTO> add(@RequestBody MalfunctionDTO dto) {
        MalfunctionDTO aDto = service.add(dto);
        return CommonResult.success(aDto, "添加成功");
    }

    @PostMapping("/malfunction/link")
    public CommonResult<MalfunctionDTO> link(@RequestBody MalfunctionDTO dto) {
        MalfunctionDTO link = service.link(dto);
        return CommonResult.success(link, "关联成功");
    }
}
