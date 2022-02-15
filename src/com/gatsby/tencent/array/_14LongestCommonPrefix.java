package com.gatsby.tencent.array;

/**
 * @author -- gatsby
 * @date -- 2022/2/13
 * @description -- leetcode 14 最长公共前缀
 */


public class _14LongestCommonPrefix {
    /*
     * @author -- gatsby
     * @description -- 纵向扫描，即使用index扫描
     * @data -- 2022/2/13
     * @param -- [strs]
     * @return -- java.lang.String
     */
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        int i = 0;
        int width = strs[0].length();
        StringBuilder res = new StringBuilder();
        while (i < width) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != c) {
                    return res.toString();
                }
            }
            res.append(c);
            ++i;
        }
        return res.toString();
    }

    /*
     * @author -- gatsby
     * @description -- 横向扫描，两两比较，比较出来的最长公共前缀再去和下一个比较
     * @data -- 2022/2/13
     * @param -- [str1, str2]
     * @return -- java.lang.String
     */
    public String prefixOf2Strs(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefixCross(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = prefixOf2Strs(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
}