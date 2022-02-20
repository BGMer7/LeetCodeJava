package com.gatsby.contest.dweek72;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 第72双周赛 5996
 * https://leetcode-cn.com/problems/count-equal-and-divisible-pairs-in-an-array/
 * Given a 0-indexed integer array nums of length n and an integer k,
 * return the number of pairs (i, j) where 0 <= i < j < n,
 * such that nums[i] == nums[j] and (i * j) is divisible by k.
 */


public class _5996CountEqualAndDivisiblePairsInArray {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> duplicate = map.getOrDefault(nums[i], new ArrayList<>());
            duplicate.add(i);
            map.put(nums[i], duplicate);
        }

        int res = 0;
        for (List<Integer> list : map.values()) {
            if (list.size() == 1) continue;
            else {
                for (int i = 0; i < list.size() - 1; ++i) {
                    for (int j = i + 1; j < list.size(); ++j) {
                        int prod = list.get(i) * list.get(j);
                        if (prod % k == 0) res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        _5996CountEqualAndDivisiblePairsInArray solution = new _5996CountEqualAndDivisiblePairsInArray();
        System.out.println(solution.countPairs(nums, 2));
    }
}