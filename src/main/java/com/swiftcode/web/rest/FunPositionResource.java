package com.swiftcode.web.rest;

import com.swiftcode.service.FunPositionService;
import com.swiftcode.service.dto.FunPositionDTO;
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
@Api(tags = "功能位置")
public class FunPositionResource {
    private FunPositionService service;

    public FunPositionResource(FunPositionService service) {
        this.service = service;
    }

    @PostMapping("/positions")
    @ApiOperation("添加功能位置")
    public CommonResult<FunPositionDTO> addPosition(@RequestBody FunPositionDTO dto) {
        FunPositionDTO position = service.addPosition(dto);
        return CommonResult.success(position, "添加成功");
    }

    @GetMapping("/positions")
    @ApiOperation("查找功能位置，返回树形结构")
    public CommonResult<List<FunPositionDTO>> findPositions() {
        List<FunPositionDTO> positions = service.findPositions();
        return CommonResult.success(positions, "查找成功");
    }
}
