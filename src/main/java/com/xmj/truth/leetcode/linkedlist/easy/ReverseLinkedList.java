package com.xmj.truth.leetcode.linkedlist.easy;

/**
 * author xiumj
 * create 2018-07-24 16:48
 * desc 反转链表
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    // 迭代
    public ListNode reverseListItertive(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next; // 防止链表反转时丢失对后一个节点的引用
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
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
