package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/2/6
 * @description -- leetcode 1748 唯一元素的和
 */


public class _1748SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : cnt.keySet()) {
            if (cnt.get(num) == 1) {
                res += num;
            }
        }
        return res;
    }
}