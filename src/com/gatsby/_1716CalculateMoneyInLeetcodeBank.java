package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/15
 * @description -- leetcode 1716 存在银行里的钱 模拟
 */


public class _1716CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int res = 0;

        for (int i = 0; i < weeks; ++i) {
            res += 28;
            res += i * 7;
        }
        for (int i = 1; i <= days; ++i) {
            res += i + weeks;
        }
        return res;
    }
}