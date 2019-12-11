package com.swiftcode.service.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * UserDeviceDTO Class
 *
 * @author Ray
 * @date 2019/12/11 14:01
 */
public class UserDeviceDTO implements Serializable {
    private static final long serialVersionUID = -6539465732386548519L;

    @ApiModelProperty(value = "设备编码")
    private String deviceCode;
    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    @ApiModelProperty(value = "功能位置编码")
    private String functionPositionCode;
    @ApiModelProperty(value = "功能位置名称")
    private String functionPositionName;
    @ApiModelProperty(value = "是否瓶颈设备")
    private Boolean bottleneckDevice;
    @ApiModelProperty(value = "剩余时间")
    private Integer restTime;
    @ApiModelProperty(value = "维护工厂编码")
    private String factoryCode;
    @ApiModelProperty(value = "工厂名称")
    private String factoryName;
    @ApiModelProperty(value = "资产卡片号")
    private String careCode;
    @ApiModelProperty(value = "ABC分类编码")
    private String abcCode;
    @ApiModelProperty(value = "ABC分类名称")
    private String abcName;



    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getFunctionPositionCode() {
        return functionPositionCode;
    }

    public void setFunctionPositionCode(String functionPositionCode) {
        this.functionPositionCode = functionPositionCode;
    }

    public String getFunctionPositionName() {
        return functionPositionName;
    }

    public void setFunctionPositionName(String functionPositionName) {
        this.functionPositionName = functionPositionName;
    }

    public Boolean isBottleneckDevice() {
        return bottleneckDevice;
    }

    public void setBottleneckDevice(Boolean bottleneckDevice) {
        this.bottleneckDevice = bottleneckDevice;
    }

    public Integer getRestTime() {
        return restTime;
    }

    public void setRestTime(Integer restTime) {
        this.restTime = restTime;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCareCode() {
        return careCode;
    }

    public void setCareCode(String careCode) {
        this.careCode = careCode;
    }

    public String getAbcCode() {
        return abcCode;
    }

    public void setAbcCode(String abcCode) {
        this.abcCode = abcCode;
    }

    public String getAbcName() {
        return abcName;
    }

    public void setAbcName(String abcName) {
        this.abcName = abcName;
    }

    @Override
    public String toString() {
        return "UserDeviceDTO{" +
            "deviceCode='" + deviceCode + '\'' +
            ", deviceName='" + deviceName + '\'' +
            ", functionPositionCode='" + functionPositionCode + '\'' +
            ", functionPositionName='" + functionPositionName + '\'' +
            ", bottleneckDevice=" + bottleneckDevice +
            ", restTime=" + restTime +
            ", factoryCode='" + factoryCode + '\'' +
            ", factoryName='" + factoryName + '\'' +
            ", careCode='" + careCode + '\'' +
            ", abcCode='" + abcCode + '\'' +
            ", abcName='" + abcName + '\'' +
            '}';
    }
}
