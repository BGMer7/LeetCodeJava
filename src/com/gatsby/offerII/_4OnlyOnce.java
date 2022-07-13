package com.gatsby.offerII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/7/13
 * @description -- 剑指 Offer II 004. 只出现一次的数字
 */


public class _4OnlyOnce {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()) {
            if (count.get(num) == 1) return num;
        }

        return -1;
    }

    public int single(int start, int[] nums) {
        return nums[start] ^ nums[start + 1] ^ nums[start + 2];
    }

    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i + 3 < nums.length; i += 3) {
            if (nums[i] != nums[i+2]) return single(i, nums);
        }
        return -1;
    }
}