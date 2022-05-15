package com.gatsby;


/**
 * @ClassName: _876MiddleOfTheLinkedList
 * @Description: leetcode 876 链表的中间节点
 * @author: Gatsby
 * @date: 2022/5/9 12:36
 */

public class _876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


