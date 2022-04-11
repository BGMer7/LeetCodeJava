package com.gatsby;

/**
 * @ClassName: _357CountNumbersWithUniqueDigits
 * @Description: leetcode 357 统计各位数字都不同的数字个数
 * @author: Gatsby
 * @date: 2022/4/11 13:17
 */

public class _357CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}


