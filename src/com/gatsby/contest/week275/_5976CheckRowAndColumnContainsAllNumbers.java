package com.gatsby.contest.week275;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/1/9
 * @description -- 周赛275 5976
 * An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
 * <p>
 * Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
 */

// https://leetcode-cn.com/problems/check-if-every-row-and-column-contains-all-numbers/
/*
内存100%
时间100%
 */
public class _5976CheckRowAndColumnContainsAllNumbers {
    public boolean isRowValid(int[] row) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int r : row) {
            if (cnt.get(r) == null) {
                cnt.put(r, 1);
            } else return false;
        }
        return true;
    }

    public boolean checkValid(int[][] matrix) {
        for (int[] row : matrix) {
            if (!isRowValid(row)) return false;
        }
        for (int i = 0; i < matrix.length; ++i) {
            int[] col = new int[matrix.length];
            for (int j = 0; j < matrix.length; ++j) {
                col[j] = matrix[j][i];
            }
            if (!isRowValid(col)) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        _5976CheckRowAndColumnContainsAllNumbers solution = new _5976CheckRowAndColumnContainsAllNumbers();
        System.out.println(solution.checkValid(arr));
    }
}