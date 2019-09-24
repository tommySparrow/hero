package com.house.hero.java.javacapacity;

/**
 * 容器测试
 * @author User
 */
public class testCapacity {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("aaa");
        myLinkedList.add("bbb");
        myLinkedList.add("vvv");
        myLinkedList.add("vvv");
        myLinkedList.add("vvv");

        System.out.println(myLinkedList.get(1));
    }
}
