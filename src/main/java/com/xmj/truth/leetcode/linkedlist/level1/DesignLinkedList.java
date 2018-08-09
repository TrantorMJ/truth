package com.xmj.truth.leetcode.linkedlist.level1;

import com.xmj.truth.leetcode.linkedlist.ListNode;

/**
 * author xiumj
 * create 2018-07-27 10:03
 * desc 设计链表
 * <p>
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * <p>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class DesignLinkedList {

    // 单链表
    public static class SingleLinkedList {

        private ListNode head;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public SingleLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;
            ListNode curr = head;
            int count = 0;
            while (count < index) {
                curr = curr.next;
                count++;
            }
            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode oldHead = head;
            ListNode newHead = new ListNode(val);
            newHead.next = oldHead;
            head = newHead;
            size++; // 链表长度加一
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode oldTail = head;
            while (oldTail.next != null) {
                oldTail = oldTail.next;
            }
            ListNode newTail = new ListNode(val);
            oldTail.next = newTail;
            size++; // 链表长度加一

        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size)
                return;
            if (index == 0) {
                this.addAtHead(val);
            } else if (index == size) {
                this.addAtTail(val);
            } else {
                ListNode curr = head;
                int count = 0;
                while (count < index) {
                    curr = curr.next;
                    count++;
                }
                ListNode newNode = new ListNode(val);
                newNode.next = curr.next;
                curr.next = newNode;
                size++;
            }

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            if(index==0){
                head = head.next;
                size--;
            }else{
                ListNode curr = head;
                int count = 0;
                while (count < index - 1) {
                    curr = curr.next;
                    count++;
                }
                curr.next = curr.next.next;
                size--;
            }
        }
    }
}
