package com.gatsby;

/**
 * @ClassName: _9PalindromeNumber
 * @Description: leetcode 9 回文数
 * @author: Gatsby
 * @date: 2022/3/17 21:00
 */

public class _9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int num = x;
        while (num > 0) {
            if (y * 10 + num % 10 > Integer.MAX_VALUE) return false;
            y = y * 10 + num % 10;
            num /= 10;
        }
        return x == y;
    }
}