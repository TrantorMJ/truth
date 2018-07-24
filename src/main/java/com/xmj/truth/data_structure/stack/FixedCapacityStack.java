package com.xmj.truth.data_structure.stack;

/**
 * author xiumj
 * create 2018-07-23 20:30
 * desc 一种表示泛型定容栈的抽象数据类型
 * API
 * FixedCapacityStack(int cap) 创建一个容量为cap的空栈
 * void push(Item item) 添加一个元素
 * Item pop() 删除最近添加的元素
 * boolean isEmpty() 栈是否为空
 * int size() 栈中的元素数量
 */
public class FixedCapacityStack<Item> {

    private Item[] a; // stack entries
    private int N; // size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop(){
        return a[--N];
    }

}
