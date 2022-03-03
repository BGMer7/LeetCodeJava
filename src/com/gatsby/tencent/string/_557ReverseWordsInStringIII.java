package com.gatsby.tencent.string;

/**
 * @author -- gatsby
 * @date -- 2022/3/3
 * @description -- leetcode 557 反转字符串中的单词
 */


public class _557ReverseWordsInStringIII {
    private String reverseString(String word) {
        char[] s = word.toCharArray();
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
        String[] words = s.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            System.out.println(word);
            stringBuilder.append(reverseString(word));
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}