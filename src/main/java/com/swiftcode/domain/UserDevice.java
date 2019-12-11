package com.swiftcode.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen
 **/
@Data
@Entity
@Table(name = "sap_user_device")
public class UserDevice implements Serializable {
    private static final long serialVersionUID = -7618518606209749347L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(18) COMMENT '设备编码'")
    private String deviceCode;
    @Column(columnDefinition = "varchar(40) COMMENT '设备名称'")
    private String deviceName;
    @Column(columnDefinition = "varchar(18) COMMENT '上级设备编码'")
    private String parentDeviceCode;
    @Column(columnDefinition = "varchar(30) COMMENT '功能位置编码'")
    private String functionPositionCode;
    @Column(columnDefinition = "varchar(40) COMMENT '功能位置名称'")
    private String functionPositionName;
    @Column(columnDefinition = "varchar(1) COMMENT '是否瓶颈设备'")
    private Boolean bottleneckDevice;
    @Column(columnDefinition = "varchar(10) COMMENT '剩余时间'")
    private Integer restTime;
    @Column(columnDefinition = "varchar(4) COMMENT '维护工厂编码'")
    private String factoryCode;
    @Column(columnDefinition = "varchar(30) COMMENT '工厂名称'")
    private String factoryName;
    @Column(columnDefinition = "varchar(12) COMMENT '资产卡片号'")
    private String careCode;
    @Column(columnDefinition = "varchar(1) COMMENT 'ABC分类编码'")
    private String abcCode;
    @Column(columnDefinition = "varchar(20) COMMENT 'ABC分类名称'")
    private String abcName;
}
