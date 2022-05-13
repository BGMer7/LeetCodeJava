package com.gatsby;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _994RottingOranges
 * @Description: leetcode 994 腐烂的橘子
 * @author: Gatsby
 * @date: 2022/5/13 16:09
 */

public class _994RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //新鲜橘子计数,用于最后判断没被感染的橘子
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //烂橘子加入队列
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++cnt;
                }
            }
        }
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        //创建时间变量来计时
        int time = 0;

        //如果新鲜橘子为0,返回0
        if (cnt == 0) return 0;


        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        //将本次队列腐烂的所有橘子压入队列
                        queue.add(new int[]{nx, ny});
                        --cnt;
                    }
                }
            }
            //BFS的每一层作为一次时间增加
            ++time;
        }
        //因为队列中最后一层橘子遍历后时间会加1,但没有橘子被继续感染,此处多了一次1
        return cnt == 0 ? time - 1 : -1;
    }
}


