package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/4/30
 * @description -- leetcode 908 最小差值
 */


public class _908SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}