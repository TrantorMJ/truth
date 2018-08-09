package com.xmj.truth.leetcode.linkedlist.level1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-25 09:41
 * desc 删除链表等于中给定值val的所有节点
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        for (ListNode first = head; first != null && first.next != null; ) {
            if (first.next.val == val) {
                first.next = first.next.next;
            } else {
                first = first.next;
            }
        }
        return head;
    }

    public ListNode removeElementsIterative(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return prev.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {

        if (head != null) {
            if (head.val == val) {
                head = removeElementsRecursive(head.next, val);
            } else {
                head.next = removeElementsRecursive(head.next, val);
            }
        }
        return head;
    }

    public ListNode removeElementsRecursiveX(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElementsRecursiveX(head.next, val);
        return head.val == val ? head.next : head;
    }
}
