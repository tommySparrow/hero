package com.house.hero.common.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Item implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String itemName;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private Integer itemPrice;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "商品创建时间")
    private Date createTime;

}