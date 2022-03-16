package com.gatsby.tencent.list;

import com.gatsby.ListNode;

/**
 * @ClassName: _160IntersectionOfTwoLinkedLists
 * @Description: leetcode 160 相交链表
 * @author: Gatsby
 * @date: 2022/3/16 14:33
 */

public class _160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        // 如果相交了，在while条件里就会跳出，如果不相交，就是同时都是null
        return nodeA;
    }
}


