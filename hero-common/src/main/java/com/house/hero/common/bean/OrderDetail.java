package com.house.hero.common.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDetail implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价格")
    private Integer totalPrice;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 关联订单表主键
     */
    @ApiModelProperty(value = "关联order表的主键")
    private Integer orderId;
}