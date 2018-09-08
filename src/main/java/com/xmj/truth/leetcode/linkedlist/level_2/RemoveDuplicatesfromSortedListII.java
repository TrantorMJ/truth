package com.xmj.truth.leetcode.linkedlist.level_2;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-08-09 18:54
 * desc 删除排序链表中的重复元素 II：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head, next = head.next;
        boolean duplicate = false;
        while (next != null) {
            while (next != null && curr.val == next.val) {
                next = next.next;
                duplicate = true;
            }
            if (duplicate) {
                curr = next;
                prev.next = curr;
                duplicate = false;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
            if (next != null)
                next = next.next;
        }
        return dummy.next;
    }


    public static ListNode deleteDuplicatesX(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        deleteDuplicates(node1);
    }
}
