package com.gatsby;

/**
 * @ClassName: _83RemoveDuplicatesFromSortedList
 * @Description: leetcode 83 删除排序链表中的重复元素
 * @author: Gatsby
 * @date: 2022/5/12 14:49
 */

public class _83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}


