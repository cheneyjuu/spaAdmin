package com.swiftcode.domain;

import cn.hutool.core.util.RandomUtil;
import com.google.common.base.Joiner;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 故障
 *
 * @author chen
 **/
@Data
@Entity
@Table(name = "sap_malfunction_jc", indexes = {
    @Index(name = "ID_IDX", columnList = "id", unique = true)
})
@ApiModel("故障")
public class Malfunction implements Serializable {
    private static final long serialVersionUID = -2855341672973203788L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    private Long id;
    /**
     * 内部单号
     */
    @Column(name = "trade_no", columnDefinition = "varchar(20) COMMENT '内部单号'")
    private String tradeNo;
    /**
     * 外部单号
     */
    @Column(name = "sap_no", columnDefinition = "varchar(50) COMMENT '外部单号'")
    private String sapNo;
    /**
     * 故障类型
     * 1：通知单；
     * 2：维修单
     */
    @Column(name = "sap_type", columnDefinition = "bit(1) COMMENT '故障类型, 1：通知单；2：维修单'")
    private Integer type;
    /**
     * 图片路径，多张图片用逗号分开
     */
    @Column(name = "picture", columnDefinition = "varchar(2000) COMMENT '图片路径，多张图片用逗号分开'")
    private String pictures;
    /**
     * 视频路径
     */
    @Column(name = "video", columnDefinition = "varchar(500) COMMENT '视频路径'")
    private String video;
    /**
     * 报修对象
     */
    @Column(name = "target", columnDefinition = "varchar(100) COMMENT '报修对象'")
    @NotBlank(message = "报修对象不能为空")
    private String target;
    /**
     * 故障描述
     */
    @Column(name = "description", columnDefinition = "varchar(2000) COMMENT '故障描述'")
    private String desc;
    /**
     * 补充故障描述
     */
    @Column(name = "addDesc", columnDefinition = "varchar(2000) COMMENT '补充故障描述'")
    private String addDesc;
    /**
     * 备注
     */
    @Column(name = "remark", columnDefinition = "varchar(2000) COMMENT '备注'")
    private String remark;
    /**
     * 是否停机
     */
    @Column(name = "is_stop", columnDefinition = "bit(1) COMMENT '是否停机'")
    private Boolean isStop;
    /**
     * 故障单提交时间
     */
    @Column(name = "create_time", columnDefinition = "datetime COMMENT '故障单提交时间'")
    private LocalDateTime createTime;

    /**
     * 新增故障
     *
     * @param pics    图片路径
     * @param video   视频路径
     * @param target  报修对象
     * @param desc    故障描述
     * @param addDesc 补充故障描述
     * @param remark  备注
     */
    public void newMalfunction(List<String> pics, String video, String target, String desc, String addDesc, String remark, Boolean isStop) {
        Objects.requireNonNull(isStop, "停机状态不能为空");
        this.tradeNo = RandomUtil.randomNumbers(12);
        this.type = 1;
        this.pictures = Joiner.on(",").join(pics);
        this.video = video;
        this.target = target;
        this.desc = desc;
        this.addDesc = addDesc;
        this.remark = remark;
        this.isStop = isStop;
        this.createTime = LocalDateTime.now();
    }

    /**
     * 关联故障
     *
     * @param sapNo 外部单号
     */
    public void linkMalfunction(String sapNo) {
        Objects.requireNonNull(this.id, "不能更新不存在的故障");
        Objects.requireNonNull(sapNo, "外部故障单号不能为空");
        this.sapNo = sapNo;
    }
}
