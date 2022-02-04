package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/2/4
 * @description -- leetcode 1725 可以形成最大正方形的矩形数目
 * number Of Rectangles That Can Form The Largest Square
 */


public class _1725NumberOfRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length;
        int[] len = new int[n];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            len[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            maxLen = Math.max(len[i], maxLen);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (len[i] == maxLen) {
                res++;
            }
        }
        return res;
    }

    public int countGoodRectanglesSimlified(int[][] rectangles) {
        int n = rectangles.length;
        int maxLen = Integer.MIN_VALUE;
        int res = 1;
        for (int i = 0; i < n; ++i) {
            int len = Math.min(rectangles[i][0], rectangles[i][1]);
            if (maxLen < len) {
                maxLen = len;
                res = 1;
            } else if (maxLen == len) {
                res++;
            }
        }
        return res;
    }
}