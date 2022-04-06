package com.gatsby;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _720LongestWordInDictionary
 * @Description: leetcode 720 词典中的最长单词
 * @author: Gatsby
 * @date: 2022/3/17 11:08
 */

public class _720LongestWordInDictionary {
    public String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : set) {
            int n = s.length();
            int m = res.length();
            if (n < m) continue;
            if (n == m && s.compareTo(res) > 0) continue;
            boolean flag = true;
            for (int i = 1; i <= n && flag; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) flag = false;
            }
            if (flag) res = s;
        }
        return res;
    }
}


