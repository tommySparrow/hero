package com.house.hero.java.java8;

import com.house.hero.common.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/2
 * @ Description：stream 的中间操作方法
 * @ throws
 */
public class StreamMid {

    List<Employee> list = Arrays.asList(
            new Employee(18, "老大", 8888.88),
            new Employee(19, "老二", 7777.77),
            new Employee(20, "老三", 6666.66),
            new Employee(21, "老四", 5555.55),
            new Employee(22, "老五", 4444.44),
            new Employee(22, "老五", 4444.44),
            new Employee(22, "老五", 4444.44),
            new Employee(22, "老五", 4444.44)
    );

    /**
     * @ Author jmy
     *过滤:
     * filter limit skip distinct
     **/
    @Test
    public void testStreamMid(){
        list.stream().filter(e -> e.getAge() >19)////过滤条件
                    .limit(5)////取出前几个
                    .skip(2)//跳过的数量
                    .distinct()//去重(根据hashcode equals)
                    .forEach(System.out::println);
    }

    /**
     * @ Author jmy
     *映射:
     * map
     **/
    @Test
    public void testStreamMidOfReflect(){
        List<String> stringList = list.stream().filter(e -> e.getAge() > 19)
                .distinct()
                .map(Employee::getName)//取出name属性
                .collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
    }
    /**
     * @ Author jmy
     *映射:
     * mapToInt mapToDouble mapToLong
     **/
    @Test
    public void testStreamMidOfMapToInt (){

        int sum = list.stream().filter(e -> e.getAge() > 19)
                .mapToInt(Employee::getAge)
                .sum();
        System.out.println(sum);
    }


    String[] strs = {"java8", "is", "easy", "to", "use"};

    /**
     * @ Author jmy
     *映射:
     * flatMap flatMapToDouble flatMapToInt flatMapToLong
     **/
    @Test
    public void testStreamMidOfFlatMap (){
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>[java8] [is]....
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>[java8is...]
                .distinct()
                .collect(Collectors.toList());

        for (String distinctStr : distinctStrs) {
            System.out.println(distinctStr);
        }
    }

    /**
     * @ Author jmy
     * 终端操作是流式处理的最后一步，我们可以在终端操作中实现对流查找、归约等操作:
     * allMatch:用于检测是否全部都满足指定的参数行为
     * anyMatch:检测是否存在一个或多个满足指定的参数行为
     * noneMatch:用于检测是否不存在满足指定行为的元素，如果不存在则返回true
     * findFirst:用于返回满足条件的第一个元素
     * findAny:相对于findFirst的区别在于，findAny不一定返回第一个，而是返回任意一个
     **/
    @Test
    public void testStreamLastStep (){

        boolean b = list.stream().allMatch(e -> e.getAge() > 20);//allMatch
        System.out.println(b);
        boolean b2 = list.stream().anyMatch(e -> e.getAge() > 20);//anyMatch
        System.out.println(b2);
        boolean b3 = list.stream().noneMatch(e -> e.getAge() > 80);//noneMatch
        System.out.println(b3);
        Optional<Employee> first = list.stream().filter(e -> e.getAge() > 20).findFirst();//findFirst
        System.out.println(first);
        Optional<Employee> second = list.stream().filter(e -> e.getAge() > 19).findAny();//findAny
        System.out.println(second);

        System.out.println("------------------------------------");
        long count = list.stream().map(Employee::getAge)
                .count();//计算总条数
        System.out.println(count);
        Optional<Integer> max = list.stream().map(Employee::getAge)
                .max(Comparator.comparingInt(x -> x));//取最大值
        System.out.println(max);

        List<Employee> employees =
                list.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());//按年龄排序
        System.out.println(employees);
    }
}
