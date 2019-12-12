package com.swiftcode.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chen
 **/
@Data
public class SapUserDTO implements Serializable {
    private static final long serialVersionUID = -7906817870388924336L;
    @ApiModelProperty(value = "人员编码")
    private String PERNR;
    @ApiModelProperty(value = "姓名")
    private String ENAME;
    @ApiModelProperty(value = "岗位代码")
    private String SORTB;
    @ApiModelProperty(value = "岗位名称")
    private String SORTT;
    @ApiModelProperty(value = "区域代码")
    private String CPLGR;
    @ApiModelProperty(value = "区域名称")
    private String CPLTX;
    @ApiModelProperty(value = "分公司编码")
    private String MATYP;
    @ApiModelProperty(value = "分公司名称")
    private String MATYT;
    @ApiModelProperty(value = "工厂代码")
    private String WERKS;
    @ApiModelProperty(value = "工厂名称")
    private String TXTMD;
    @ApiModelProperty(value = "是否维修人员")
    private String WCTYPE;
}
