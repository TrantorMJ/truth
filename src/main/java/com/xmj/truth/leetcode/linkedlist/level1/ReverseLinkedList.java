package com.xmj.truth.leetcode.linkedlist.level1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-24 16:48
 * desc 反转链表
 */
public class ReverseLinkedList {

    // 迭代
    public ListNode reverseListItertive(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next; // 防止链表反转时丢失对后一个节点的引用
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
