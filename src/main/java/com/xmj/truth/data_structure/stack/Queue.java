package com.xmj.truth.data_structure.stack;

import java.util.Iterator;

/**
 * author xiumj
 * create 2018-07-24 15:28
 * desc 先进先出队列（链表实现）
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first; // 指向最早添加的节点的链接
    private Node last; // 指向最添加的节点的链接
    private int N; // 队列中的元素数量

    // 定义了节点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; // 或：N==0
    }

    public int size() {
        return N;
    }

    // 向表尾添加元素
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) { // 入列时如果队列为空，首节点和尾节点相同且为null,
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    // 从表头删除元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) { // 出列后如果队列为空，首节点和尾节点相同且为null;
            last = null;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
