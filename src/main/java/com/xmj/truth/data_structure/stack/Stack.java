package com.xmj.truth.data_structure.stack;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * author xiumj
 * create 2018-07-24 15:01
 * desc 下压栈（链表实现）
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first; // 栈顶（最近添加的元素）
    private int N; // 元素数量

    // 定义嵌套的节点类
    private class Node {
        Item item;
        Node next;
    }

    // 或N==0
    public boolean isEmpty() {
        return first == null;
    }

    public int size(){
        return N;
    }

    // 向栈顶添加元素
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // 从栈顶删除元素
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
