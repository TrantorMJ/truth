package com.xmj.truth.data_structure.stack;

/**
 * author xiumj
 * create 2018-07-23 17:18
 * desc 一种表示定容字符串栈的抽象数据类型
 * API
 * FixedCapacityStackOFStrings(int cap) 创建一个容量为cap的空栈
 * void push(String item) 添加一个字符串
 * String pop() 删除最近添加的字符串
 * boolean isEmpty() 栈是否为空
 * int size() 栈中的字符串数量
 */
public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(String item){
        a[N++] = item;
}

    public String pop(){
        return a[--N];
    }
}