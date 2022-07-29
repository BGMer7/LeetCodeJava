package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/7/22
 * @description -- leetcode 1529 最少的后缀翻转次数
 */


public class _1529MinimumSuffixFlips {
    public int minFlips(String target) {
        if (target.length() == 0) return 0;
        int count = 0;
        char base = target.charAt(0);
        if (base == '1') count++;
        for (int i = 1; i < target.length(); ++i) {
            if (target.charAt(i) != base) {
                count++;
                base = target.charAt(i);
            }
        }
        return count;
    }
}