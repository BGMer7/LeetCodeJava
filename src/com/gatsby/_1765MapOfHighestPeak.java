package com.gatsby;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author -- gatsby
 * @date -- 2022/1/29
 * @description -- leetcode 1765 地图最高点
 */


public class _1765MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int[][] res = new int[row][col];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 一开始在图画表格上模拟的时候，默认的格子是空，然后一层一层加1
                // 一开始是想res[i][j] = isWater[i][j]^1，只要异或0变成1，1变成0就行
                // 但是不行，需要将默认值和真的高度为1区分开来
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int[] di : dirs) {
                int xNext = x + di[0];
                int yNext = y + di[1];

                if (xNext < 0 || yNext < 0 || xNext > row || yNext > col) continue;
                if (res[xNext][yNext] != -1) continue;
                res[xNext][yNext] = res[x][y] + 1;
                queue.add(new int[]{xNext, yNext});
            }
        }
        return res;
    }
}