package com.xmj.truth.data_structure.source_code;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * author xiumj
 * create 2018-08-01 18:44
 * desc 链表源码分析
 */
public class LinkedList<E> extends AbstractSequentialList implements List<E>, Deque<E>, Cloneable, Serializable {

    /**
     * 节点类
     *
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * transient:
     * 1.被transient修饰的变量不再是对象持久化的一部分；
     * 2.transient只能修饰变量，不能修饰类和方法；
     * 3.一个静态变量不管是否被transient修饰，均不能被序列化
     * 4.transient只有在类实现的是Serializable接口时才有效
     */
    transient int size = 0;

    /**
     * 指向头结点
     * 不变式: (first==null&&last==null)||(first.prev==null&&first.item!=null)
     */
    transient Node<E> first;

    /**
     * 指向尾节点
     * 不变式: (first==null&&last==null)||(last.next==null&&last.item!=null)
     */
    transient Node<E> last;

    /**
     * 构造一个空链表
     */
    public LinkedList() {
    }

    /**
     * 链接e作为第一个元素
     *
     * @param e
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node(null, e, f);
        first = newNode;
        if (f == null) // 如果原链表为空链表，则将last指针指向新节点，此时first和last指针指向同一个节点，否则将原头结点的next指针指向新节点
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++; // 此变量用于记录链表结构被修改的次数
    }

    /**
     * 链接e作为最后一个元素
     *
     * @param e
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(l, e, null);
        if (l == null) // 如果原链表为空链表，则将first指针指向新节点，此时first和last指针指向同一个节点，否则将原尾节点的prev指针指向新节点
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 在非空节点succ前插入节点e
     *
     * @param e
     * @param succ
     */
    void linkBefore(E e, Node<E> succ) {
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) // 如果原链表只有一个节点，则将first指针指向新节点，否则将succ的前一个节点的next指针指向新节点
            first = newNode;
        else
            prev.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 删除头结点
     *
     * @param f
     * @return
     */
    private E unlinkfirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // 防止对象游离
        if (next == null) // 如果原链表只有一个节点，则将last指针指向null，否则将原头结点后一个节点的prev节点指向null
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;

    }

    /**
     * 删除尾节点
     *
     * @param l
     * @return
     */
    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // 防止对象游离
        last = prev;
        if (prev == null) // 如果原链表只有一个节点，则将first指针指向null，否则将原尾结点后一个节点的next节点指向null
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }



}
