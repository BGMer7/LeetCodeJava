package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _387FirstUniqueCharacterInString
 * @Description: leetcode 387 字符串中的第一个唯一字符
 * @author: Gatsby
 * @date: 2022/5/10 19:08
 */

public class _387FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; ++i) {
            if (count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}


