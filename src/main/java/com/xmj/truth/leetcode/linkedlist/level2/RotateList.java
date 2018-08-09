package com.xmj.truth.leetcode.linkedlist.level2;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-08-09 15:37
 * desc 旋转链表：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // 计算链表长度
        int length = 0;
        for (ListNode x = head; x != null; x = x.next)
            length++;

        // 计算链表实际移动长度
        int move = k % length;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < move; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotateRightX(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // 计算链表长度
        int length = 1;
        ListNode fast;
        for (fast = head; fast.next != null; fast = fast.next)
            length++;

        ListNode slow = head;
        for (int i = 1; i < length - k % length; i++) {
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
