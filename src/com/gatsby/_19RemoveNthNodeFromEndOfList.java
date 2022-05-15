package com.gatsby;

/**
 * @ClassName: _19RemoveNthNodeFromEndOfList
 * @Description: leetcode 19 删除链表的倒数第N个节点
 * @author: Gatsby
 * @date: 2022/5/9 12:43
 */

public class _19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 为什么要创建一个dummy节点呢？因为head也有可能被删除的
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int k = n;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (k-- != 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}


