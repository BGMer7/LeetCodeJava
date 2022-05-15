package com.gatsby;

/**
 * @ClassName: _733FloodFill
 * @Description: leetcode 733 图像渲染
 * @author: Gatsby
 * @date: 2022/5/11 10:22
 */

public class _733FloodFill {
    private int[][] image;
    private int originColor;

    private void dfs(int r, int c, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length
                || image[r][c] != originColor || image[r][c] == newColor)
            return;

        image[r][c] = newColor;
        dfs(r, c + 1, newColor);
        dfs(r + 1, c, newColor);
        dfs(r - 1, c, newColor);
        dfs(r, c - 1, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.originColor = image[sr][sc];
        dfs(sr, sc, newColor);
        return this.image;
    }
}


