package com.xmj.truth.leetcode.linkedlist.level_2;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-08-08 20:23
 * desc 两两交换链表中的节点
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        int index = 0;
        ListNode curr = head;
        ListNode prev = new ListNode(0); // 自建前一个节点
        while (curr != null && curr.next != null) {
            if (index % 2 == 0) { // 注意点：是"%"而不是"/"
                ListNode next = curr.next;
                if (index == 0) {
                    head = next;
                }
                curr.next = next.next;
                next.next = curr;
                prev.next = next;
                prev = next;

            } else {
                prev = prev.next;
                curr = curr.next;
            }
            index++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(node1);
    }
}
