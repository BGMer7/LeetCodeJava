package com.gatsby.contest.dweek72;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 第72双周赛 5998
 * https://leetcode-cn.com/problems/maximum-split-of-positive-even-integers/
 * You are given an integer finalSum. Split it into a sum of a maximum number of unique positive even integers.
 * For example, given finalSum = 12,
 * the following splits are valid (unique positive even integers summing up to finalSum):
 * (2 + 10), (2 + 4 + 6), and (4 + 8). Among them, (2 + 4 + 6) contains the maximum number of integers.
 * Note that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be unique.
 * Return a list of integers that represent a valid split containing a maximum number of integers.
 * If no valid split exists for finalSum, return an empty list.
 * You may return the integers in any order.
 */


public class _5998MaximumSplitOfPositiveEvenIntegers {
    /*
     * @author -- gatsby
     * @description -- 从2 4 6 8一直下去，然后特殊处理最后一个数字即可
     * @data -- 2022/2/20
     * @param -- [finalSum]
     * @return -- java.util.List<java.lang.Long>
    */
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) return new ArrayList<Long>();
        List<Long> res = new ArrayList<>();
        if (finalSum == 2) {
            res.add((long) 2);
            return res;
        }
        if (finalSum == 4) {
            res.add((long) 4);
            return res;
        }
        long sum = 0;
        long even = 2;
        while (sum <= finalSum) {
            res.add(even);
            sum += even;
            if (sum == finalSum) return res;
            even += 2;
        }

        sum -= res.get(res.size() - 1);
        res.remove(res.size() - 1);
        long lastNum = res.get(res.size() - 1);
        res.remove(res.size() - 1);
        res.add(lastNum + (finalSum - sum));
        return res;
    }

    public static void main(String[] args) {
        _5998MaximumSplitOfPositiveEvenIntegers solution = new _5998MaximumSplitOfPositiveEvenIntegers();
        System.out.println(solution.maximumEvenSplit(16));
    }
}