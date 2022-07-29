package com.gatsby;

/**
 * @ClassName: _921MinimumAddToMakeParenthesesValid
 * @Description: 921. Minimum Add to Make Parentheses Valid
 * @author: Gatsby
 * @date: 2022/7/29 12:02
 */

public class _921MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (left == 0) {
                    count++;
                } else if (left > 0) {
                    left--;
                }
            } else {
                left++;
            }
        }
        return left + count;
    }
}


