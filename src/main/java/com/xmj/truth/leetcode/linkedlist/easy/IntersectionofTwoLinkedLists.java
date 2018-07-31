package com.xmj.truth.leetcode.linkedlist.easy;

/**
 * author xiumj
 * create 2018-07-31 15:31
 * desc 相交链表
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lengthA = 0;
        int lengthB = 0;
        for (ListNode first = headA; first != null; first = first.next)
            lengthA++;
        for (ListNode first = headB; first != null; first = first.next)
            lengthB++;

        ListNode longHead = null;
        ListNode shortHead = null;
        int diff = 0;
        if (lengthA >= lengthB) {
            longHead = headA;
            shortHead = headB;
            diff = lengthA - lengthB;
        } else {
            longHead = headB;
            shortHead = headA;
            diff = lengthB - lengthA;
        }
        for (int i = 0; i < diff; i++) {
            longHead = longHead.next;
        }
        while (shortHead != null && longHead != null) {
            if (shortHead == longHead) {
                return shortHead;
            }
            shortHead = shortHead.next;
            longHead = longHead.next;
        }
        return null;
    }

    /**
     * 大多数解决方案在这里预处理链接列表以获得长度的差异，
     * 实际上我们并不关心差异的价值，我们只想确保两个指针同时到达交叉点节点
     * 我们可以使用两次迭代来做到这一点：
     * 在第一次迭代中，我们将在到达尾节点之后将一个链表的指针重置到另一个链表的头部;
     * 在第二次迭代中，我们将移动两个指针，直到他们指向同一个节点，我们在第一次迭代中的操作将帮助我们抵消差异。
     * 因此，如果两个链表相交，则第二次迭代中的汇合点必须是交点；
     * 如果两个链表根本没有交集，那么第二次迭代中的汇合点必须是两个列表的尾节点，也就是null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeAwesome(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode first = headA;
        ListNode second = headB;
        // 如果两个链表长度不同，我们将在第二次迭代中终止循环
        while (first != second) {
            // 在第一次迭代结束时，将指针重置为另一个链表的头结点
            first = first != null ? first.next : headB;
            second = second != null ? second.next : headA;
        }
        return first;
    }
}
