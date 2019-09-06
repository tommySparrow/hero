package com.house.hero.thread;

public class MyThead3 extends Thread {

    private int count = 5;
    @Override
    synchronized public void run() {

        count --;
        System.out.println("由"+Thread.currentThread().getName() +"计算,"+ "count="+count);
    }

    public static void main(String[] args) {

        MyThead3 myThead3 = new MyThead3();
        Thread a = new Thread(myThead3, "a");
        Thread b = new Thread(myThead3, "b");
        Thread c = new Thread(myThead3, "c");
        Thread d = new Thread(myThead3, "d");
        Thread e = new Thread(myThead3, "e");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
