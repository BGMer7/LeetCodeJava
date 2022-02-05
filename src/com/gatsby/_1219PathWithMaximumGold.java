package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/2/5
 * @description -- leetcode 1219 黄金矿工
 */


public class _1219PathWithMaximumGold {
    private int row = 0;
    private int col = 0;
    private int[][] grid;
    private boolean[][] visited;
    static private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int x, int y) {
        int res = grid[x][y];
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col
                    || grid[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
            else {
                visited[nextX][nextY] = true;
                res = Math.max(res, grid[x][y] + dfs(nextX, nextY));
                visited[nextX][nextY] = false;
            }
        }
        return res;
    }

    public int getMaximumGold(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] != 0) {
                    visited[i][j] = true;
                    res = Math.max(res, dfs(i, j));
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean[][] visited = new boolean[2][2];
        System.out.println(visited[0][1]);
    }
}