package com.swiftcode.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 功能位置
 *
 * @author chen
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sap_fun_position")
public class FunPosition extends AbstractAuditingEntity {
    private static final long serialVersionUID = -3969368004470218633L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    private Long id;
    @Column(name = "parent_id", columnDefinition = "bigint COMMENT '父节点ID'")
    private Long parentId;
    @Column(name = "user_code", columnDefinition = "varchar(10) COMMENT '员工编号'")
    private String userCode;
    @Column(name = "position_code", columnDefinition = "varchar(30) COMMENT '功能位置编码'")
    private String positionCode;
    @Column(name = "position_name", columnDefinition = "varchar(30) COMMENT '功能位置名称'")
    private String positionName;
}
