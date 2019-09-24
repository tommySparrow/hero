package com.house.hero.java.javacapacity;

public class MyLinkedList {

    private Node first;
    private Node last;
    private int size;

    /**
     * 添加节点
     *
     * @param obj
     */
    public void add(Object obj) {

        final Node l = last;
        final Node newNode = new Node(l, obj, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 获取节点
     */
    public Object get(int index) {

        try {
            checkElementIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Node node = node(index);
        return node.obj;
    }

    /**
     * 移除节点
     */
    public void remove(int index) {
        Node node = node(index);

        if (null != node) {
            Node up = node.previous;
            Node down = node.next;
            up.next = down;
            down.previous = up;
            size--;
        }
    }

    /**
     * 指定位置添加节点
     *
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        Node temp = node(index);

        Node newNode = new Node();
        newNode.obj = obj;

        if (temp != null) {
            Node up = temp.previous;
            up.next = newNode;

            newNode.previous = up;
            newNode.next = temp;

            temp.previous = newNode;

            size++;
        }
    }

    private void checkElementIndex(int index) throws Exception {
        if (!(index >= 0 && index < size)) {
            throw new Exception();
        }
    }

    /**
     * 获取节点
     *
     * @param index
     * @return
     */
    Node node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.previous;
            }
            return x;
        }
    }
}
