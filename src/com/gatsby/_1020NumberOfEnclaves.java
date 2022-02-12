package com.gatsby;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author -- gatsby
 * @date -- 2022/2/12
 * @description -- leetcode 1020 飞地的数量
 */


public class _1020NumberOfEnclaves {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int m, n;
    private boolean[][] visited;

    private void dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return;
        } else {
            visited[x][y] = true;
            for (int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                dfs(nextX, nextY, grid);
            }
        }
    }

    /*
     * @author -- gatsby
     * @description -- DFS
     * @data -- 2022/2/12
     * @param -- [grid]
     * @return -- int
    */
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        if (m <= 0) {
            return 0;
        }
        n = grid[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            dfs(i, 0, grid);
            dfs(i, n - 1, grid);
        }
        for (int i = 1; i < n - 1; ++i) {
            dfs(0, i, grid);
            dfs(m - 1, i, grid);
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += (grid[i][j] == 1 && !visited[i][j] ? 1 : 0);
            }
        }
        return res;
    }

    /*
     * @author -- gatsby
     * @description -- BFS
     * @data -- 2022/2/12
     * @param -- [grid]
     * @return -- int
    */
    public int numEnclavesBfs(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (grid[i][n - 1] == 1) {
                queue.offer(new int[]{i, n - 1});
                visited[i][n - 1] = true;
            }
        }

        for (int i = 1; i < n - 1; ++i) {
            if (grid[0][i] == 1) {
                queue.offer(new int[]{0, i});
                visited[0][i] = true;
            }
            if (grid[m - 1][i] == 1) {
                queue.offer(new int[]{m - 1, i});
                visited[m - 1][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            for (int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n &&
                        grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        System.out.println();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += (grid[i][j] == 1 && !visited[i][j] ? 1 : 0);
            }
        }
        return res;
    }
}