package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Role implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Date createTime;
}