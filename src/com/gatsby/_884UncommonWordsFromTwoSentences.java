package com.gatsby;

import java.util.*;

/**
 * @author -- gatsby
 * @date -- 2022/1/30
 * @description -- leetcode 884 两句话中的不常见单词
 */


public class _884UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;
        String[] words = s.split(" ");
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                res.add(word);
            }
        }
        return (String[]) res.toArray();
    }
}