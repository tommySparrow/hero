package com.house.hero.common.bean;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jerry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Excel(name = "age/年龄")
    private Integer age;
    /**
     * 不使用@Excel 这个字段将读取为null
     */
    @Excel(name = "name/名字")
    private String name;
    @Excel(name = "salary/薪资")
    private Double salary;
}
