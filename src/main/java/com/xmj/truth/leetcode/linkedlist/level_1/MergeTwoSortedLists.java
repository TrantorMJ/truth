package com.xmj.truth.leetcode.linkedlist.level_1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-26 17:19
 * desc 合并两个有序链表
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        /*// 边界条件 l1和l2均为空
        if (l1 == null && l2 == null) {
            return null;
        }*/
        // 判断合并后的链表头部
        ListNode head = null;
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            head = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            head = l2;
            l2 = l2.next;
        }
        ListNode curr = head;
        // 迭代合并链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            curr.next = l1;
            curr = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr.next = l2;
            curr = l2;
            l2 = l2.next;
        }
        return head;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            head = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            head = l2;
            l2 = l2.next;
        }else{
            return null;
        }
        head.next = mergeTwoListsRecursive(l1,l2);
        return head;
    }

    public ListNode mergeTwoListsRecursiveX(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<=l2.val){
            l1.next  = mergeTwoListsRecursiveX(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoListsRecursiveX(l1,l2.next);
            return l2;
        }
    }
}
