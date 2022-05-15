package com.gatsby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _1337TheKWeakestRowsInMatrix
 * @Description: leetcode 1337 矩阵中战斗力最弱的K行
 * @author: Gatsby
 * @date: 2022/5/13 23:28
 */

public class _1337TheKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            int power = 0;
            for (int j = 0; j < col; ++j) {
                power += mat[i][j];
            }
            list.add(new int[]{power, i});
        }

        Collections.sort(list, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = list.get(i)[1];
        }
        return res;
    }
}


