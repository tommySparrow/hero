package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleMenu implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 菜单id
     */
    private Integer menuId;
}