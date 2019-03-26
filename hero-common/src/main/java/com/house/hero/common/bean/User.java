package com.house.hero.common.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "用户创建时间")
    private Date createTime;

    /**
     * 角色
     */
    private List<Role> roleList;
}