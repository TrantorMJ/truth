package com.xmj.truth.leetcode.linkedlist.level_1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-26 16:53
 * desc 回文链表
 */
public class PalindromeLinkedList {

    // 翻转链表后半部分，然后比较前后两部分
    public boolean isOalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果链表节点数量为奇数，slow前进一个节点
        if (fast != null) {
            slow = slow.next;
        }

        // 翻转后半部分
        slow = this.reverseLinkedList(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
