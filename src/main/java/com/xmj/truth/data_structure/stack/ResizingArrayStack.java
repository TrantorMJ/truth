package com.xmj.truth.data_structure.stack;

import java.util.Iterator;

/**
 * author xiumj
 * create 2018-07-24 10:08
 * desc 能够动态调整数组大小的栈实现
 * <p>
 * modified 2018-07-24 10:08
 * desc 能够动态调整数组大小的栈实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; // 元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 将栈移动到一个大小为max的新数组
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // 将元素添加到栈顶
    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    // 从栈顶删除元素
    public Item pop(){
        Item item = a[--N];
        a[N] = null; // 防止对象游离
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    // 支持后进先出的迭代
    private class ReverseArrayIterator implements Iterator<Item>{

        private int i = N;

        public boolean hasNext() {
            return i>0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}
