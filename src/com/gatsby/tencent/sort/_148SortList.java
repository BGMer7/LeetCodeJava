package com.gatsby.tencent.sort;

import com.gatsby.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _148SortList
 * @Description: leetcode 148 排序链表
 * @author: Gatsby
 * @date: 2022/3/22 13:33
 */

public class _148SortList {
    /**
     * @MethodName: sortListArray
     * @Parameter: [head]
     * @Return com.gatsby.ListNode
     * @Description: 利用数组排序，时间复杂度可以达到o(nlogn)，但是空间复杂度是O(n)
     * @author: Gatsby
     * @date: 2022/3/22 13:55
     */
    public ListNode sortListArray(ListNode head) {
        ListNode root = head;
        List<Integer> nums = new ArrayList<>();
        while (root != null) {
            nums.add(root.val);
            root = root.next;
        }

        Collections.sort(nums);
        ListNode res = new ListNode();
        ListNode copy = res;
        for (int i = 0; i < nums.size(); ++i) {
            res.next = new ListNode(nums.get(i));
            res = res.next;
        }
        return copy.next;
    }

    private ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode curr = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return root.next;
    }

    /**
     * @MethodName:  sortList
     * @Parameter: [head]
     * @Return com.gatsby.ListNode
     * @Description: 递归写法，空间复杂度也是O(n)
     * @author: Gatsby
     * @date:  2022/3/22 14:09
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidNode(head);
        ListNode right = mid.next;
        mid.next = null;

        return mergeTwoLists(sortList(head), sortList(right));
    }
}


