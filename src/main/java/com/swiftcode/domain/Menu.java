package com.swiftcode.domain;

import com.google.common.collect.Lists;
import com.swiftcode.service.dto.MenuDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/**
 * @author chen
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pt_menu")
public class Menu extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = -1287391989182223378L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    private Long id;
    @Column(name = "text", columnDefinition = "varchar(20) COMMENT '菜单名称'")
    private String text;
    @Column(name = "parent_id", columnDefinition = "bigint COMMENT '父菜单ID'")
    private Long parentId = 0L;
    @Column(name = "icon", columnDefinition = "varchar(20) COMMENT '菜单ICON'")
    private String icon;
    @Column(name = "link", columnDefinition = "varchar(80) COMMENT '菜单路径'")
    private String link;
    @Column(name = "menu_order", columnDefinition = "int COMMENT '菜单排序'")
    private Integer order;
    @Transient
    private List<Menu> children = Lists.newArrayList();

    private Menu() {
    }

    public static Comparator<MenuDTO> order() {
        return (o1, o2) -> {
            if (!o1.getOrder().equals(o2.getOrder())) {
                return o1.getOrder() - o2.getOrder();
            }
            return 0;
        };
    }
}
