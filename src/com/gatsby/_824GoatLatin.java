package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/4/21
 * @description -- leetcode 824 山羊拉丁文
 */


public class _824GoatLatin {
    private static List<Character> vowels = new ArrayList<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    private String convert(String word) {
        if (vowels.contains(word.charAt(0))) {
            return word + "ma";
        } else {
            return word.substring(1) + word.charAt(0) + "ma";
        }
    }

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            words[i] = convert(words[i]);
            int t = i + 1;
            while (t-- != 0) {
                words[i] += "a";
            }
            sb.append(" ");
            sb.append(words[i]);
        }
        return sb.substring(1);
    }
}