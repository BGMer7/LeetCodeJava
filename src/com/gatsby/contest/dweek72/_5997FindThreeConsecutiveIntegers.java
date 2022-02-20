package com.gatsby.contest.dweek72;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 第72双周赛 5997
 * https://leetcode-cn.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
 * Given an integer num, return three consecutive integers (as a sorted array) that sum to num.
 * If num cannot be expressed as the sum of three consecutive integers, return an empty array.
 */


public class _5997FindThreeConsecutiveIntegers {
    public long[] sumOfThree(long num) {
        return num % 3 == 0 ? new long[]{num / 3 - 1, num / 3, num / 3 + 1} : new long[0];
    }
}