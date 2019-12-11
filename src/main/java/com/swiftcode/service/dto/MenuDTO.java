package com.swiftcode.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO implements Serializable {
    private static final long serialVersionUID = -8208093754852338542L;
    private Long id;
    private String text;
    private Long parentId;
    private String icon;
    private String link;
    private Integer order;
    private List<MenuDTO> children;
}
