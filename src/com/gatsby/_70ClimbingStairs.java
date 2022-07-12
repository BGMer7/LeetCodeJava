package com.gatsby;

/**
 * @ClassName: _70ClimbingStairs
 * @Description: leetcode 70 爬楼梯
 * @author: Gatsby
 * @date: 2022/5/16 16:45
 */

public class _70ClimbingStairs {
    /**
     * @MethodName: climbStairs
     * @Parameter: [n]
     * @Return int
     * @Description: 实际就是前两个数相加，可以改成常数空间
     * @author: Gatsby
     * @date: 2022/5/16 16:49
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n + 1];
    }

    public int climbStairsConstant(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;

        int first = 1;
        int second = 2;
        int res = 0;

        while (n-- >= 3) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}


