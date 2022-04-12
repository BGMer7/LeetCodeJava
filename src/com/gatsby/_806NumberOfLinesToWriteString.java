package com.gatsby;

/**
 * @ClassName: _806NumberOfLinesToWriteString
 * @Description: leetcode 806 写字符串需要的行数
 * @author: Gatsby
 * @date: 2022/4/12 10:29
 */

public class _806NumberOfLinesToWriteString {
    public static final int MAX_WIDTH = 100;

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > MAX_WIDTH) {
                lines++;
                width = need;
            }
        }
        return new int[]{lines, width};
    }
}


