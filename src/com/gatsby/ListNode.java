package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/16
 * @description -- leetcode ListNode类
 */


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}