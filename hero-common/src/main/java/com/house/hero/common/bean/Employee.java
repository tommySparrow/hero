package com.house.hero.common.bean;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jerry
 */
@Data
@AllArgsConstructor
public class Employee implements Serializable {
    private Integer age;
    private String name;
    private Double salary;
}
