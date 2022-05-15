package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _242ValidAnagram
 * @Description: leetcode 242 有效的字母异位
 * @author: Gatsby
 * @date: 2022/5/10 20:35
 */

public class _242ValidAnagram {
    /**
     * @MethodName:  isAnagram
     * @Parameter: [s, t]
     * @Return boolean
     * @Description: 除了计数的办法，还可以排序
     * @author: Gatsby
     * @date:  2022/5/10 20:40
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }
}


