package com.swiftcode.web.rest;

import com.swiftcode.service.MalfunctionService;
import com.swiftcode.service.dto.MalfunctionDTO;
import com.swiftcode.service.util.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/malfunction")
    public CommonResult<MalfunctionDTO> findByTradeNo(@RequestParam(value = "tradeNo", required = false) String tradeNo,
                                                      @RequestParam(value = "id", required = false) Long id) {
        Optional<MalfunctionDTO> dto;
        if (null != tradeNo) {
            dto = service.findByTradeNo(tradeNo);
        } else {
            dto = service.findById(id);
        }
        return dto.map(CommonResult::success).orElseGet(CommonResult::failed);
    }
}
