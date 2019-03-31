package com.house.hero;
import com.house.hero.common.bean.Employee;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee(18, "老大", 8888.88),
                new Employee(19, "老二", 7777.77),
                new Employee(20, "老三", 6666.66),
                new Employee(21, "老四", 5555.55),
                new Employee(22, "老五", 4444.44)
        );

        /**
         * stream api
         */
        list.stream()
                //过滤条件
                .filter((e) -> e.getAge() >= 20)
                //取出前几个
                .limit(2)
                //取出对象属性放入map中
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
