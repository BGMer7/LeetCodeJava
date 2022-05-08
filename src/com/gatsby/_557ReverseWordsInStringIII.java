package com.gatsby;

/**
 * @ClassName: _557ReverseWordsInStringIII
 * @Description: leetcode 557 反转字符串中的单词III
 * @author: Gatsby
 * @date: 2022/5/8 9:36
 */

public class _557ReverseWordsInStringIII {
    private String reverseString(String word) {
        char[] s= word.toCharArray();
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            --right;
            ++left;
        }
        return String.valueOf(s);

    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: words) {
            stringBuilder.append(reverseString(word));
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}


