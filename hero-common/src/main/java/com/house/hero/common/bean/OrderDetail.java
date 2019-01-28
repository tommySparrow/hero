package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDetail implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 总价
     */
    private Integer totalPrice;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

}