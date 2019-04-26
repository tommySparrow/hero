package com.house.hero.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/25
 * @ Description：
 * @ throws
 */
@Data
@AllArgsConstructor
public class EasyPOIModel {
    private int id;
    private String project;
    private String name;
    private String sex;
    private int age;
}
