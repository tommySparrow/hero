package com.house.hero.javacapacity;

/**
 * 容器测试
 * @author User
 */
public class testCapacity {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("123");
        myArrayList.add("abc");
        System.out.println(myArrayList.get(0));
    }
}
