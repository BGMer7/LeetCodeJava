package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _1509MinDiffInThreeMove
 * @Description: leetcode 1509 三次操作后最大值与最小值的最小差
 * @author: Gatsby
 * @date: 2022/3/17 22:52
 */

public class _1509MinDiffInThreeMove {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; ++i) {
            // 1,5,0,10,14
            // 0,1,5,10,14
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}


