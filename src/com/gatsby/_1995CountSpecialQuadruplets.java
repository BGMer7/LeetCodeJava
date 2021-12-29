package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2021/12/29
 * @description -- leetcode 1995 统计特殊的四元数组
 */


public class _1995CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int c = n - 2; c >= 2; --c) {
            cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; ++a) {
                for (int b = a + 1; b < c; ++b) {
                    res += cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1995CountSpecialQuadruplets solution = new _1995CountSpecialQuadruplets();
        System.out.println(solution.countQuadruplets(new int[]{1, 2, 3, 6}));
    }
}