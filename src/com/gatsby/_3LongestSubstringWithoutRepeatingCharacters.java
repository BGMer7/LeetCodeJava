package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _3LongestSubstringWithoutRepeatingCharacters
 * @Description: leetcode 3  Longest Substring Without Repeating Characters
 * @author: Gatsby
 * @date: 2022/5/10 20:44
 */

public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < n; ++end) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return res;
    }
}


