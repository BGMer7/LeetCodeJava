package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/2/2
 * @description -- leetcode  2000 反转单词前缀
 */


public class _2000ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index < 0) return word;
        return new StringBuilder(word.substring(0, index + 1)).reverse() + word.substring(index + 1);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s.indexOf('l'));
        System.out.println(s.indexOf('a'));
        System.out.println(s.substring(0, 5));
    }
}