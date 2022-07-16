package com.gatsby.offerII;

/**
 * @author -- gatsby
 * @date -- 2022/7/16
 * @description -- 剑指 Offer II 099. 最小路径之和
 */


public class _99MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1) {
            int sum = 0;
            for (int i : grid[0]) {
                sum += i;
            }
            return sum;
        }

        if (col == 1) {
            int sum = 0;
            for (int[] i : grid) {
                sum += i[0];
            }
            return sum;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}