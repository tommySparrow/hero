package com.house.hero.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/16
 * @ Description：线程池的学习
 * @ throws
 */
public class Pool_demo implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void run() {
        System.out.println("执行时间：" + format.format(new Date()) + "      线程ID：  " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Pool_demo demo = new Pool_demo();
        ExecutorService es = newFixedThreadPool(5);//容量为5的线程池
        //创建5个线程的线程池
        for (int i = 0; i < 10; i++) {
            es.execute(demo);
        }
    }
}
