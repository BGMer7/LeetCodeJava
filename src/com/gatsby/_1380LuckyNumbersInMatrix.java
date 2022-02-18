package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/2/15
 * @description -- leetcode 1380 矩阵中的幸运数
 */


public class _1380LuckyNumbersInMatrix {
    private int minIndex(int[] row) {
        int n = row.length;
        if (n == 1) return 0;
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; ++i) {
            if (Math.min(min, row[i]) == row[i]) {
                min = row[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int maxNum(int[][] matrix, int col) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; ++i) {
            maxNum = Math.max(maxNum, matrix[i][col]);
        }
        return maxNum;
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        // if (row == 1) return new ArrayList<>(matrix[0][minIndex(matrix[0])]);
        List<Integer> res = new ArrayList<>();
        for (int[] ints : matrix) {
            int minIndex = minIndex(ints);
            if (maxNum(matrix, minIndex) == ints[minIndex]) {
                res.add(ints[minIndex]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1380LuckyNumbersInMatrix solution = new _1380LuckyNumbersInMatrix();
        System.out.println(solution.luckyNumbers(new int[][]{{76618,42558,65788,20503,29400,54116}}));
    }
}