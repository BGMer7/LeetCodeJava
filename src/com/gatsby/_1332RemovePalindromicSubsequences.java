package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/22
 * @description -- leetcode 1332 移除回文子序列
 */


public class _1332RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                return 2;
            }
        }
        return 1;
    }
}