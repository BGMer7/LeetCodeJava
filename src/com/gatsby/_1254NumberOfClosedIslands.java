package com.gatsby;

public class _1254NumberOfClosedIslands {
    private int[][] isVisited;
    int row;
    int col;
    int res;

    private boolean dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) return false; // 和边界接壤，实际上不属于被包围
        if (isVisited[i][j] == 1) return true;
        isVisited[i][j] = 1;
        // 不能使用&&因为我们需要在每一次遍历中都把所有的格子都标记，但是如果使用&&，一旦前提条件不符合，后面的dfs就不会执行了
        return dfs(i - 1, j) & dfs(i, j - 1) & dfs(i + 1, j) & dfs(i, j + 1);
    }


    public int closedIsland(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        this.isVisited = grid;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (isVisited[i][j] == 0 && dfs(i, j))
                    res++;
            }
        }
        return res;
    }
}
