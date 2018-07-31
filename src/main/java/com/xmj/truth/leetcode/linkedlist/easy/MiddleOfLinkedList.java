package com.xmj.truth.leetcode.linkedlist.easy;

/**
 * author xiumj
 * create 2018-07-31 14:45
 * desc 链表的中间节点
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            length++;
        }
        int middleIndex = 0;
        ListNode middle = head;
        while (middleIndex < length / 2) {
            middle = middle.next;
            middleIndex++;
        }
        return middle;
    }

    // 两个指针，慢指针每次走一步，快指针每次走两步，快指针到达链表尾节点，慢指针到达链表中间节点
    public ListNode middleNodeX(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
