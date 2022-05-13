package com.gatsby;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: _542Matrix
 * @Description: leetcode 542 01矩阵
 * @author: Gatsby
 * @date: 2022/5/13 14:22
 */

public class _542Matrix {
    private int[][] dis;
    private int[][] visited;
    private int row;
    private int col;

    /*
    如果每个遍历，找到非零元素，然后一圈一圈开始遍历，那就变成了暴力搜索
    但是实际上我们可以利用已经找到过0的元素
    */
    public int[][] updateMatrix(int[][] mat) {
        this.dis = new int[mat.length][mat[0].length];
        this.visited = new int[mat.length][mat[0].length];
        this.row = mat.length;
        this.col = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 0) {
                    visited[i][j] = -1;
                    dis[i][j] = 0;
                    // 把0加入队列中，虽然这道题的目的是找到0，但是实际做法是从0出发的
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        int dist = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; ++i) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                dis[x][y] = dist;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col &&
                            visited[nx][ny] != -1 && mat[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = -1;
                    }
                }
            }
            dist++;
        }
        return dis;
    }
}


