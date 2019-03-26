package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 关联用户表主键
     */
    private Integer userId;

    /**
     * 关联角色表主键
     */
    private Integer roleId;
}