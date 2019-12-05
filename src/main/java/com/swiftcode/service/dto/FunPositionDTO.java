package com.swiftcode.service.dto;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 功能位置
 *
 * @author chen
 **/
@Data
public class FunPositionDTO implements Serializable {
    private static final long serialVersionUID = 6407933089387949428L;
    private Long id;
    @ApiModelProperty(value = "父节点ID")
    private Long parentId;
    @ApiModelProperty(value = "员工工号")
    private String userCode;
    @ApiModelProperty(value = "功能位置编码")
    private String positionCode;
    @ApiModelProperty(value = "功能位置名称")
    private String positionName;
    @ApiModelProperty(value = "功能位置子节点")
    private List<FunPositionDTO> children = Lists.newArrayList();
    @ApiModelProperty(value = "设备子节点")
    private List<DeviceDTO> deviceChildren = Lists.newArrayList();
}
