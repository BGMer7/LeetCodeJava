package com.gatsby.tencent.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _20ValidParentheses
 * @Description: leetcode 20 有效的括号
 * @author: Gatsby
 * @date: 2022/3/3 15:08
 */

public class _20ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char parenthesis = s.charAt(i);
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                stack.offerLast(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (parenthesis == ')' && stack.peekLast() == '(') {
                    stack.pollLast();
                } else if (parenthesis == '}' && stack.peekLast() == '{') {
                    stack.pollLast();
                } else if (parenthesis == ']' && stack.peekLast() == '[') {
                    stack.pollLast();
                } else {
                    stack.offerLast(parenthesis);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20ValidParentheses solution = new _20ValidParentheses();
        solution.isValid("(])");
    }
}


