package com.house.hero.java.java8;

import com.house.hero.common.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/3
 * @ Description：reduce 的使用
 * @ throws
 */
public class ReduceMethod {

    List<Employee> list = Arrays.asList(
            new Employee(18, "老大", 8888.88),
            new Employee(19, "老二", 7777.77),
            new Employee(20, "老三", 6666.66),
            new Employee(21, "老四", 5555.55),
            new Employee(22, "老五", 4444.44)
    );

    /**
     * @ Author jmy
     * reduce 使用
     **/
    @Test
    public void testReduce(){

        Integer reduce = list.stream().map(Employee::getAge)
                .reduce(0, (x, y) -> x + y);//0为累加初始值
        System.out.println(reduce);
        Optional<Integer> reduce1 = list.stream().map(Employee::getAge)
                .reduce((x, y) -> x + y);
        System.out.println(reduce1.get());
    }
}
