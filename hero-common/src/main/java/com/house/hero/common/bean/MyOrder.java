package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MyOrder implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 对应user表主键id
     */
    private Integer userId;

    /**
     * 订单内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * User
     */
    private User user;
}