package com.swiftcode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * SAP用户信息
 *
 * @author chen
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sap_user")
public class SapUser extends AbstractAuditingEntity {
    private static final long serialVersionUID = -5075711990508043734L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    private Long id;
    @JsonIgnore
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;
    @Column(name = "user_code", columnDefinition = "varchar(10) COMMENT '人员编码'", unique = true)
    @NotNull(message = "'员工编码' 字段不能为空")
    private String userCode;
    @Column(name = "user_name", columnDefinition = "varchar(10) COMMENT '人员姓名'")
    @NotNull(message = "'员工姓名' 字段不能为空")
    private String userName;
    @Column(name = "job_code", columnDefinition = "varchar(10) COMMENT '岗位代码'")
    private String jobCode;
    @Column(name = "job_name", columnDefinition = "varchar(50) COMMENT '岗位名称'")
    private String jobName;
    @Column(name = "region_code", columnDefinition = "varchar(10) COMMENT '区域代码'")
    private String regionCode;
    @Column(name = "region_name", columnDefinition = "varchar(50) COMMENT '区域名称'")
    private String regionName;
    @Column(name = "branch_code", columnDefinition = "varchar(10) COMMENT '分公司代码'")
    private String branchCode;
    @Column(name = "branch_name", columnDefinition = "varchar(50) COMMENT '分公司名称'")
    private String branchName;
    @Column(name = "factory_code", columnDefinition = "varchar(10) COMMENT '工厂代码'")
    private String factoryCode;
    @Column(name = "factory_name", columnDefinition = "varchar(30) COMMENT '工厂名称'")
    private String factoryName;
    @Column(name = "is_mal_staff", columnDefinition = "char COMMENT '是否维修人员'")
    @NotNull(message = "'是否维修人员' 字段不能为空")
    private String isMalStaff;
    @Column(name = "phone_number", columnDefinition = "varchar(30) COMMENT '手机号'")
    private String phoneNumber;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "sap_user_authority",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();
}
