package com.gatsby;

import java.util.Arrays;

/**
 * @author -- gatsby
 * @date -- 2022/1/29
 * @description -- leetcode 135 分发糖果
 */


public class _135Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int i = 0;
        while (i < n - 1) {
            if (ratings[i] < ratings[i + 1]) {
                res[i + 1] = res[i] + 1;
            }
            ++i;
        }
        while (i > 0) {
            if (ratings[i - 1] > ratings[i]) {
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
            --i;
        }
        int sum = 0;
        for (int c: res) {
            sum+=c;
        }
        return sum;
    }
}