package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _1984MinimumDifferenceBetweenHighestAndLowest
 * @Description: leetcode 1984 学生分数的最小差值
 * @author: Gatsby
 * @date: 2022/2/11 17:23
 */

public class _1984MinimumDifferenceBetweenHighestAndLowest {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        return minDiff;
    }
}


