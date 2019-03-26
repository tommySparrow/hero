package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * url
     */
    private String url;

    /**
     * 权限
     */
    private String perms;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer orderNum;
}