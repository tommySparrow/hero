package com.house.hero.java8;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/1
 * @ Description：Java8常用函数
 * @ throws
 */
public class FourFunctions {


    /**
     * @ Author jmy
     * @ Description Function 接口接收一个参数，并返回单一的结果//TODO User
     **/
    @Test
    public void testFunction(){
        Function<String,Integer> sum = Integer::valueOf;
        Integer apply = sum.apply("123");
        System.out.println(apply);
    }

    /**
     * @ Author jmy
     * @ Description Predicate 断言接口//TODO User
     **/
    @Test
    public void testPredicate(){
        Predicate<String> pre = (str) -> str.contains("o");
        boolean b = pre.test("com");
        System.out.println(b);
    }

    /**
     * @ Author jmy
     * @ Description Supplier 提供者//TODO User
     **/
    @Test
    public void testSupplier(){
        Supplier<Integer> sup = () -> (int) (Math.random() * 10);
        System.out.println(sup.get());
    }


    /**
     * @ Author jmy
     * @ Description Consumer 消费型//TODO User
     **/
    @Test
    public void testConsumer(){
        Consumer<String> con = System.out::println;
        con.accept("hello consumer");
    }
}
