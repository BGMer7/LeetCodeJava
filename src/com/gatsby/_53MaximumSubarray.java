package com.gatsby;

/**
 * @ClassName: _53MaximumSubarray
 * @Description: leetcode 53 最大子数组和
 * @author: Gatsby
 * @date: 2022/5/5 16:11
 */

public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            res = Math.max(res, sum);
        }
        return res;
    }
}


