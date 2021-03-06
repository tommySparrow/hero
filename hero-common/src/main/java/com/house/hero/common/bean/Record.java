package com.house.hero.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Record implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String account;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String des;

    /**
     * 
     */
    private String company;
}