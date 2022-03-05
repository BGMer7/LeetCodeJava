package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/3/5
 * @description -- leetcode 521 最长特殊序列I
 */


public class _521LongestUncommonSubsequenceI {
    /*
     * @author -- gatsby
     * @description -- 其实是一个脑筋急转弯，如果两个字符串不相等
     * 那么长的那个就是最长特殊序列
     * 如果两个字符串相等，那么返回-1
     * @data -- 2022/3/5
     * @param -- [a, b]
     * @return -- int
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}