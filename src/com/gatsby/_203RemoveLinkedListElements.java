package com.gatsby;

/**
 * @ClassName: _203RemoveLinkedListElements
 * @Description: leetcode 203 移除链表元素
 * @author: Gatsby
 * @date: 2022/5/11 12:43
 */

public class _203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode res = dummy;
        dummy = dummy.next;

        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next= dummy.next.next;
            }else {
                dummy = dummy.next;
            }
        }
        return res.next;
    }
}


