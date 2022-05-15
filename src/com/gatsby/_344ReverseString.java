package com.gatsby;

/**
 * @ClassName: _344ReverseString
 * @Description: leetcode 344 反转字符串
 * @author: Gatsby
 * @date: 2022/5/8 9:22
 */

public class _344ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}


