package com.xmj.truth.leetcode.linkedlist.easy;

/**
 * author xiumj
 * create 2018-07-25 09:45
 * desc 单链表定义
 */
public class ListNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        String str = String.valueOf(val);
        if(next!=null){
            str+= "->"+next.toString();
        }
        return str;
    }
}
