package com.gatsby.offerII;

import com.gatsby.ListNode;

/**
 * @ClassName: _21RemoveNthFromEnd
 * @Description: 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * <p>
 * 1 -> 2 -> 3 -> 4 -> 5
 * @author: Gatsby
 * @date: 2022/7/14 13:38
 */

public class _21RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- != 0) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}


