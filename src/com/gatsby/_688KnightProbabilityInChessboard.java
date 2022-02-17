package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/2/17
 * @description -- leetcode 688 骑士在棋盘上的概率
 */


public class _688KnightProbabilityInChessboard {
    /*
    f[x][y][k] = (Σf[nextX][nextY][k-1]*1/8)
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        // 当k=0，概率都是1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j][0] = 1;
            }
        }

        for (int step = 1; step <= k; ++step) {
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < n; ++y) {
                    for (int[] dir : directions) {
                        int nextX = x + dir[0];
                        int nextY = y + dir[1];
                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                        dp[x][y][step] += (dp[nextX][nextY][step - 1] / 8);
                    }
                }
            }
        }
        return dp[row][column][k];
    }
}