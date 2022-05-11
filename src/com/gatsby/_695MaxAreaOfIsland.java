package com.gatsby;

/**
 * @ClassName: _695MaxAreaOfIsland
 * @Description: leetcode 695 岛屿的最大面积
 * @author: Gatsby
 * @date: 2022/5/11 10:45
 */

public class _695MaxAreaOfIsland {
    private int[][] grid;
    private int gridRow;
    private int gridCol;
    private int maxArea;

    private void dfs(int row, int col) {
        if (row < 0 || row >= gridRow || col < 0 || row >= gridCol
                || grid[row][col] == -1 || grid[row][col] == 0)
            return;

        maxArea++;
        grid[row][col] = -1;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.gridRow = grid.length;
        this.gridCol = grid[0].length;
        int res = 0;

        for (int i = 0; i < gridRow; ++i) {
            for (int j = 0; j < gridCol; ++j) {
                if (grid[i][j] != 0 && grid[i][j] != -1) {
                    dfs(i, j);
                    res = Math.max(res, maxArea);
                    this.maxArea = 0;
                }
            }
        }
        return res;
    }
}


