package com.gatsby;

/**
 * @ClassName: _74SearchMatrix
 * @Description: leetcode 74 搜索二维矩阵
 * @author: Gatsby
 * @date: 2022/5/12 16:06
 */

public class _74SearchMatrix {
    public boolean searchMatrix(int[][] grid, int target) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == target) return true;
            }
        }
        return false;
    }

    public boolean searchMatrixBS(int[][] grid, int target) {
        int row = grid.length;
        int col = grid[0].length;

        int up = 0;
        int down = row - 1;

        while (up < down) {
            int mid = up + (down - up + 1) / 2;
            if (grid[mid][0] == target) return true;
            else if (grid[mid][0] > target) down = mid - 1;
            else if (grid[mid][0] < target) up = mid;
        }

        int left = 0;
        int right = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (grid[up][mid] == target) return true;
            else if (grid[up][mid] > target) right = mid - 1;
            else if (grid[up][mid] < target) left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}};
        _74SearchMatrix solution = new _74SearchMatrix();
        System.out.println(solution.searchMatrixBS(grid, 1));
    }
}


