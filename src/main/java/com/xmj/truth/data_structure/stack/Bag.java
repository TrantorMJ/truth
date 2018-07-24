package com.xmj.truth.data_structure.stack;

import java.util.Iterator;

/**
 * author xiumj
 * create 2018-07-24 16:06
 * desc 背包（链表实现）
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first; // 链表的首节点

    private class Node {
        Item item;
        Node next;
    }

    // 向背包中添加元素
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        // 实例变量current记录链表的当前节点
        private Node current = first;

        // 检测current是否为null
        public boolean hasNext() {
            return current != null;
        }

        // 保存当前元素的引用，将current变量指向链表的下个节点并返回所保存的引用
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }
}
