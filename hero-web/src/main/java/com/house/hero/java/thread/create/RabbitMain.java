package com.house.hero.java.thread.create;

/**
 * @author User
 */
public class RabbitMain {
    public static void main(String[] args) {
        //创建子类对象
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        //调用start()方法
        rabbit.start();
        tortoise.start();
    }
}
