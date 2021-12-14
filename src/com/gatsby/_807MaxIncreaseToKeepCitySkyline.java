package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2021/12/13
 * @description -- leetcode 807 to keep sky line
 */

public class _807MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        final int size = grid.length;
        int[] maxInRow = new int[size];
        int[] maxInCol = new int[size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                maxInRow[i] = Math.max(grid[i][j], maxInRow[i]);
                maxInCol[j] = Math.max(grid[i][j], maxInCol[j]);
            }
        }

        int maxIncrease = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                maxIncrease += Math.min(maxInRow[i], maxInCol[j]) - grid[i][j];
            }
        }

        return maxIncrease;
    }
}