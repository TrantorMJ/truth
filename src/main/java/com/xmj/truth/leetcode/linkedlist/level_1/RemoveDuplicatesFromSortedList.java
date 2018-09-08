package com.xmj.truth.leetcode.linkedlist.level_1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-26 16:25
 * desc 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null && next != null) {
            if (curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
            next = curr.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesX(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
