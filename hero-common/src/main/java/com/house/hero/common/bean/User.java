package com.house.hero.common.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;
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
    @Excel(name = "用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Excel(name = "密码")
    private String password;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "用户创建时间")
    @Excel(name = "进校日期",format = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 角色
     */
    @ExcelIgnore
    @Transient
    private List<Role> roleList;
}