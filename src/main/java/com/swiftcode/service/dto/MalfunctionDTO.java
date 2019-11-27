package com.swiftcode.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 **/
@Data
public class MalfunctionDTO implements Serializable {
    private static final long serialVersionUID = -6586175462386548519L;
    private Long id;
    @ApiModelProperty(value = "员工工号")
    private String userCode;
    @ApiModelProperty(value = "工单标题")
    private String title;
    @ApiModelProperty(value = "设备等级")
    private String level;
    @ApiModelProperty(value = "工单状态")
    private String status;
    @ApiModelProperty(value = "位置")
    private String location;
    @ApiModelProperty(value = "设备")
    private String device;
    @ApiModelProperty(value = "上报时长")
    private String reportTime;
    @ApiModelProperty(value = "等待时长")
    private String waitTime;
    @ApiModelProperty(value = "内部单号", required = true)
    private String tradeNo;
    @ApiModelProperty(value = "外部单号")
    private String sapNo;
    @ApiModelProperty(value = "故障类型, 1：通知单；2：维修单", required = true)
    private Integer type;
    @ApiModelProperty(value = "图片路径，多张图片用逗号分开")
    private List<String> pictures;
    @ApiModelProperty(value = "视频路径")
    private String video;
    @ApiModelProperty(value = "报修对象", required = true)
    private String target;
    @ApiModelProperty(value = "故障描述")
    private String desc;
    @ApiModelProperty(value = "补充故障描述")
    private String addDesc;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "是否停机")
    private Boolean isStop;
    @ApiModelProperty(value = "故障单提交时间")
    private String createTime;
}
