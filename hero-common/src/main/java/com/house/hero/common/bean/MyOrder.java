package com.house.hero.common.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MyOrder implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 对应user表主键id
     */
    @ApiModelProperty(value = "关联用户表主键id")
    private Integer userId;

    /**
     * 订单内容
     */
    @ApiModelProperty(value = "内容信息")
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    /**
     * User
     */
    private User user;

    /**
     * 详情信息(理解为产品详情)
     */
    private List<OrderDetail> orderDetails;

}