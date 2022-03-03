package com.gatsby.tencent.string;

/**
 * @author -- gatsby
 * @date -- 2022/3/3
 * @description -- leetcode 344 反转字符串
 */


public class _344ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
}