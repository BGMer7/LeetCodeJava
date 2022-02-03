package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/2/3
 * @description -- leetcode 1414 和为 K 的最少斐波那契数字数目
 */


public class _1414FindTheMinimumNumberOfFibonacci {
    public int findMinFibonacciNumbers(int k) {
        if (k <= 2) return 1;
        List<Integer> Fibonacci = new ArrayList<>();
        Fibonacci.add(1);
        Fibonacci.add(1);
        int a = 1, b = 1, c = a + b;
        while (c <= k) {
            c = a + b;
            Fibonacci.add(c);
            a = b;
            b = c;
        }

        int ptr = Fibonacci.size() - 1;
        int res = 0;
        while (k > 0 && ptr >= 0) {
            int num = Fibonacci.get(ptr);
            if (num <= k) {
                k -= num;
                res++;
            }
            ptr--;
        }
        return res;
    }
}