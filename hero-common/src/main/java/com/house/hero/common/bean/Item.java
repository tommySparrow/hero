package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Item implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品价格
     */
    private Integer itemPrice;

    /**
     * 创建时间
     */
    private Date createTime;

}