package com.gatsby.tencent.list;

import com.gatsby.ListNode;

/**
 * @author -- gatsby
 * @date -- 2022/3/6
 * @description -- leetcode 2 两数相加
 */


public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            int val = sum % 10;
            if (head == null) {
                head = new ListNode(val);
                node = head;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return head;
    }
}