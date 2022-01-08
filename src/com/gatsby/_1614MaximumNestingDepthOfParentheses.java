package com.gatsby;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author -- gatsby
 * @date -- 2022/1/8
 * @description -- Leetcode 1614 大括号的最大深度
 */


public class _1614MaximumNestingDepthOfParentheses {
    // stack只是用来记录size，那其实维护一个int参数就可以
    public int maxDepth(String s) {
        int res = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                res = Math.max(res, stack.size());
                stack.pop();
            }
        }
        return res;
    }

    public int maxDepthSimplified(String s) {
        int res = 0, parentheses = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                parentheses++;
            } else if (s.charAt(i) == ')') {
                res = Math.max(res, parentheses);
                parentheses--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1614MaximumNestingDepthOfParentheses solution = new _1614MaximumNestingDepthOfParentheses();
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(solution.maxDepthSimplified("(1)+((2))+(((3)))"));
    }
}