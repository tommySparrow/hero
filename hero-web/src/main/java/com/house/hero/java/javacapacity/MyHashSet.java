package com.house.hero.java.javacapacity;

import java.util.HashMap;

/**
 * 自定义hashSet
 *
 * @author User
 */
public class MyHashSet {

    private transient HashMap map;
    int size;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }


    /**
     * 添加数据
     *
     * @param o
     */
    public void add(Object o) {
        if (!map.containsKey(o)) {
            map.put(o, PRESENT);
            size++;
        }
    }
}
