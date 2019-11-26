package com.swiftcode.service.dto;

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
    /**
     * 内部单号
     */
    private String tradeNo;
    /**
     * 外部单号
     */
    private String sapNo;
    /**
     * 故障类型
     * 1：通知单；
     * 2：维修单
     */
    private Integer type;
    /**
     * 图片路径
     */
    private List<String> pictures;
    /**
     * 视频路径
     */
    private String video;
    /**
     * 报修对象
     */
    private String target;
    /**
     * 故障描述
     */
    private String desc;
    /**
     * 补充故障描述
     */
    private String addDesc;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否停机
     */
    private Boolean isStop;
    /**
     * 创建时间
     */
    private String createTime;
}
