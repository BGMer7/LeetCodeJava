package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/31
 * @description -- leetcode 1342 将数字变成零的操作次数
 */


public class _1342NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num >= 1) {
            if (num % 2 == 1) {
                num--;
            } else {
                num /= 2;
            }
            res++;
        }
        return res;
    }
}