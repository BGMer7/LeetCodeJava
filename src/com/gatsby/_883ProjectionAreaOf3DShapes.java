package com.gatsby;

/**
 * @ClassName: _883ProjectionAreaOf3DShapes
 * @Description: leetcode 三维形体投影面积
 * @author: Gatsby
 * @date: 2022/4/26 18:22
 */

public class _883ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] g) {
        int bottom = 0;
        int side = 0;
        int front = 0;
        int n = g.length;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] > 0) bottom++;
                a = Math.max(a, g[i][j]);
                b = Math.max(b, g[j][i]);
            }
            side += a; front += b;
        }
        return bottom + side + front;
    }
}


