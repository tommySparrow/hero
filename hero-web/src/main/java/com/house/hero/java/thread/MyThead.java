package com.house.hero.java.thread;

public class MyThead extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            try {
                MyThead myThead = new MyThead();
                myThead.setName("myThread");
                myThead.start();

                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
