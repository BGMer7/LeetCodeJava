package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _54SpiralMatrix
 * @Description: leetcode 54 螺旋矩阵
 * @author: Gatsby
 * @date: 2022/1/18 17:18
 */

public class _54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
                int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; ++i)
                res.add(matrix[up][i]);
            if (++up > down) break;

            for (int i = up; i <= down; ++i)
                res.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; --i)
                res.add(matrix[down][i]);
            if (--down < up) break;

            for (int i = down; i >= up; --i)
                res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        _54SpiralMatrix solution = new _54SpiralMatrix();

        System.out.println(solution.spiralOrder(a));
    }
}


