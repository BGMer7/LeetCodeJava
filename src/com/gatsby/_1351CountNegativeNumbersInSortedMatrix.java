package com.gatsby;

/**
 * @ClassName: _1351CountNegativeNumbersInSortedMatrix
 * @Description: leetcode 1351 统计有序矩阵中的负数
 * @author: Gatsby
 * @date: 2022/5/12 15:22
 */

public class _1351CountNegativeNumbersInSortedMatrix {
    /**
     * @MethodName:  countNegatives
     * @Parameter: [grid]
     * @Return int
     * @Description: 适用于main函数中的矩阵，并不适合题目中的矩阵
     * @author: Gatsby
     * @date:  2022/5/12 15:44
     */
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int up = 0;
        int down = row - 1;

        while (up < down) {
            int mid = up + (down - up + 1) / 2;
            if (grid[mid][0] >= 0) down = mid - 1;
            else if (grid[mid][0] < 0) up = mid;
        }

        int left = 0;
        int right = col - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (grid[up][mid] >= 0) right = mid - 1;
            else if (grid[up][mid] < 0) left = mid;
        }

        return up * col + left + 1;
    }

    /**
     * @MethodName:  countNegativesPtr
     * @Parameter: [grid]
     * @Return int
     * @Description: 指针的思路
     * @author: Gatsby
     * @date:  2022/5/12 15:55
     */
    public int countNegativesPtr(int[][] grid) {
        int res = 0;
        int row = 0, col = grid[0].length - 1;
        // 从最右上角开始
        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                res += grid.length - row;
                // 向左移动
                col--;
            } else {
                // 向下移动
                row++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{-9, -8, -7, -6}, {-4, -3, -2, -1}, {0, 1, 2, 3, 4}};
        _1351CountNegativeNumbersInSortedMatrix solution = new _1351CountNegativeNumbersInSortedMatrix();
        System.out.println(solution.countNegatives(grid));
    }
}


