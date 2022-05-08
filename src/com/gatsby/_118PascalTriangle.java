package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _118PascalTriangle
 * @Description: leetcode 118 杨辉三角
 * @author: Gatsby
 * @date: 2022/5/8 9:59
 */

public class _118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                // 最外面的边是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}


