package com.gatsby;

import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: _804UniqueMorseCodeWords
 * @Description: leetcode 804 唯一摩尔斯密码词
 * @author: Gatsby
 * @date: 2022/4/10 1:14
 */

public class _804UniqueMorseCodeWords {
    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> res = new TreeSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                stringBuilder.append(MORSE[word.charAt(i)-'a']);
            }
            res.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }
        return res.size();
    }
}


