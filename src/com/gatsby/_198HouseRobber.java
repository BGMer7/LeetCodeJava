package com.gatsby;

/**
 * @ClassName: _198HouseRobber
 * @Description: leetcode 198 打家劫舍
 * @author: Gatsby
 * @date: 2022/3/21 16:06
 */

public class _198HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        // 选有钱的偷，不是非要第一天就偷
        dp[1] = Math.max(nums[0], nums[1]);
        // 状态转移方程：dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}


