package com.xmj.truth.leetcode.linkedlist.level_1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * author xiumj
 * create 2018-07-27 10:08
 * desc 环形链表
 */
public class LinkedListCycle {

    // HashSet 要检测链表是否是有环的，可以判断某个节点是否被访问过
    public boolean hasCycle(ListNode head) {

        // 如果链表为空或者只有一个节点，则不为环形链表
        if (head == null || head.next == null)
            return false;

        // 判断节点是否被访问过
        Set<ListNode> recordSet = new HashSet<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (recordSet.contains(curr)) {
                return true;
            } else {
                recordSet.add(curr);
            }
        }
        return false;
    }

    // HashSet 要检测链表是否是有环的，可以判断某个节点是否被访问过
    public boolean hasCycleX(ListNode head) {

        Set<ListNode> recordSet = new HashSet<>();
        while (head != null) {
            if (recordSet.contains(head)) {
                return true;
            } else {
                recordSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 两个指针，慢指针每次走一步，快指针每次走两步，若链表有环，则二者必然相遇
    public boolean hasCycleXX(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
