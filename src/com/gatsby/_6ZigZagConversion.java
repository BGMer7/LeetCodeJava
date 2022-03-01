package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/3/1
 * @description -- leetcode 6 zigzag
 */


public class _6ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int index = 1;
        while (index < n) {
            for (int i = 1; i < numRows && index < n; i++) {
                sbs[i].append(s.charAt(index++));
            }
            for (int i = numRows - 2; i > -1 && index < n; i--) {
                sbs[i].append(s.charAt(index++));
            }
        }
        for (StringBuilder sb : sbs) {
            ans.append(sb);
        }
        return ans.toString();
    }
}