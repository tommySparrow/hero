package com.house.hero.java.javacapacity;

import java.util.LinkedList;

/**
 * 自定义map实现
 *
 * @author User
 */
public class MyMap {

    /**
     * 固定大小数组模式
     */
    LinkedList[] arr = new LinkedList[9];
    int size;

    /**
     * 自定义map存储数据
     */
    public void put(Object key, Object value) {

        Entry entry = new Entry(key, value);
        int hash = key.hashCode();
        hash = hash < 0 ? -hash : hash;

        //计算数组index
        int index = hash % arr.length;

        if (arr[index] == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(entry);
            arr[index] = linkedList;
            size++;
        } else {
            //获取当前位置的链表
            LinkedList linkedList = arr[index];
            for (int i = 0; i < linkedList.size(); i++) {

                //链表中的key值和传入的key值相同;值覆盖
                Entry e2 = (Entry) linkedList.get(i);
                if (e2.key.equals(key)) {
                    e2.value = value;
                    return;
                }
            }
            //key值不重复,往链表中拼接对象
            linkedList.add(entry);
            size++;
        }
    }

    /**
     * 自定义get方法
     *
     * @param key
     * @return
     */
    public Object get(Object key) {

        int hash = key.hashCode();
        hash = hash < 0 ? -hash : hash;
        //计算数组index
        int index = hash % arr.length;

        if (null != arr[index]) {
            //获取当前位置的链表
            LinkedList linkedList = arr[index];
            for (int i = 0; i < linkedList.size(); i++) {

                Entry entry = (Entry) linkedList.get(i);
                if (entry.key.equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
}
