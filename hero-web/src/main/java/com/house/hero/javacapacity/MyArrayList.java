package com.house.hero.javacapacity;

import java.util.Arrays;

/**
 * 自定义ArrayList实现
 *
 * @author User
 */
public class MyArrayList {


    /**
     * non-private to simplify nested class access
     */
    transient Object[] elementData;

    /**
     * The size of the ArrayList
     */
    private int size;

    /**
     * 空参构造函数
     */
    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * 自定义add方法
     */
    public boolean add(Object e) {
        //数组扩容和数据拷贝
        if (size == elementData.length) {
            //存入数据等于数组长度时进行扩容
            Object[] newArray = new Object[size * 2 + 1];
            //拷贝
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);

            //从新赋值数组
            elementData = Arrays.copyOf(elementData, newArray.length);
        }
        elementData[size++] = e;
        return true;
    }

    /**
     * 自定义remove
     *
     * @param index
     * @return
     */
    public Object remove(int index) {

        //校验是否越界
        try {
            rangeCheck(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        }
        // clear to let GC do its work
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * Replaces the element of index
     *
     * @param index
     * @param element
     * @return
     */
    public Object set(int index, Object element) {
        try {
            rangeCheck(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public Object get(int index) {
        try {
            rangeCheck(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementData(index);
    }

    private Object elementData(int index) {
        return elementData[index];
    }

    private void rangeCheck(int index) throws Exception {
        //角标越界
        if (index >= size) {
            throw new Exception();
        }
    }

}