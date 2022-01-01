package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/1
 * @description -- 2022 leetcode 一维数组转换二维数组
 */


public class _2022Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][];
        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; ++i) {
            // System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            System.arraycopy(original, i, res[i / n], 0, m);
        }
        return res;
    }
}