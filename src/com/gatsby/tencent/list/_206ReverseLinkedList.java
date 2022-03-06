package com.gatsby.tencent.list;

import com.gatsby.ListNode;

/**
 * @author -- gatsby
 * @date -- 2022/3/6
 * @description -- leetcode 206 反转列表
 */


public class _206ReverseLinkedList {
    /*
     * @author -- gatsby
     * @description -- 迭代
     * @data -- 2022/3/6
     * @param -- [head]
     * @return -- com.gatsby.ListNode
     */
    public ListNode reverseListIter(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverseListRecur(head.next);

        head.next.next = head;
        head.next = null;
        return root;
    }
}