package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/16
 * @description -- leetcode ListNode类
 */


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}