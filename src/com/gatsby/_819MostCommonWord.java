package com.gatsby;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _819MostCommonWord
 * @Description: leetcode 819 最常见的单词
 * @author: Gatsby
 * @date: 2022/4/17 15:32
 */

public class _819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        String[] words = paragraph.split("[\\p{Space}\\p{Punct}]");
        for (String ban : bannedList) {
            ban = ban.toLowerCase();
        }
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (word.equals("")) continue;
            word = word.toLowerCase();
            if (!bannedList.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        String res = "";
        int freq = Integer.MIN_VALUE;
        for (String word : count.keySet()) {
            if (count.get(word) > freq) {
                res = word.toLowerCase();
                freq = count.get(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _819MostCommonWord solution = new _819MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String res = solution.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }
}


