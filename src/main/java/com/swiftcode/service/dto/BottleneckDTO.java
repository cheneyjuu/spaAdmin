package com.swiftcode.service.dto;

import java.util.Date;

/**
 * BottleneckDTO Class
 *
 * @author Ray
 * @date 2019/12/11 14:31
 */
public class BottleneckDTO {
    private static final long serialVersionUID = -6539465732315468975L;

    private String userCode;
    private String userName;
    private String deviceCode;
    private String deviceName;
    private Date startTime;
    private Date endTime;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BottleneckDTO{" +
            "\"userCode\":'" + userCode + '\'' +
            ", \"userName\":'" + userName + '\'' +
            ", \"deviceCode\":'" + deviceCode + '\'' +
            ", \"deviceName\":'" + deviceName + '\'' +
            ", \"startTime\":" + startTime +
            ", \"endTime=\":" + endTime +
            '}';
    }
}
