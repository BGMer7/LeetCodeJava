package com.gatsby;

/**
 * @ClassName: _2047NumberOfValidWordsInASentence
 * @Description: leetcode 2047 句子中的有效单词数 // 没啥意义
 * @author: Gatsby
 * @date: 2022/1/27 9:47
 */

public class _2047NumberOfValidWordsInASentence {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0) return false;
        if (n == 1) {
            char c = s.charAt(0);
            return ('a' <= c && c <= 'z') || c == '.' || c == '!' || c == ',';
        }

        int hyfen = 0;
        if (s.charAt(0) == '-' || s.charAt(n - 1) == '-') {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z' || c == '-') && hyfen < 2) {
                if (c == '-') {
                    hyfen++;
                }
            } else {
                if (i == n - 1) {
                    return (s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z') && (s.charAt(i) == ',' || s.charAt(i) == '.' || s.charAt(i) == '!');
                }
                return false;
            }
        }
        return true;
    }

    public int countValidWords(String sentence) {
        String[] splited = sentence.split(" ");
        int res = 0;
        for (String s : splited) {
            if (isValid(s)) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        _2047NumberOfValidWordsInASentence solution = new _2047NumberOfValidWordsInASentence();
        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        // System.out.println(solution.isValid("pencils"));
    }
}


