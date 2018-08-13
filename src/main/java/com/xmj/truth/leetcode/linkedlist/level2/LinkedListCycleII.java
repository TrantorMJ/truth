package com.xmj.truth.leetcode.linkedlist.level2;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-08-11 09:58
 * desc 环形链表:给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {

        // 如果链表为空或者链表只有一个节点，则链表无环
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, slow = head;

        // 环长度
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            length++;
            if (fast == slow)
                break;
        }

        // 快指针到达链表尾节点，无环
        if (fast == null || fast.next == null)
            return null;

        // 确定链表有环，计算入环节点
        fast = head;
        slow = head;
        for (int i = 0; i < length; i++)
            fast = fast.next;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode detectCycleX(ListNode head) {

        // 如果链表为空或者链表只有一个节点，则链表无环
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        //ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode result = detectCycle(node1);
        System.out.println("result.val = " + result.val);
    }
}
