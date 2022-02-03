package com.gatsby.tencent.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/2/2
 * @description -- leetcode 1 两数之和
 */


public class _1TwoSum {
    /*
     * @author -- gatsby
     * @description -- HashMap 空间换时间
     * @data -- 2022/2/2
     * @param -- [nums, target]
     * @return -- int[]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (map.get(diff) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(diff), i};
            }
        }
        return new int[]{0, 0};
    }

    /*
     * @author -- gatsby
     * @description -- 暴力两层循环
     * @data -- 2022/2/2
     * @param -- [nums, target]
     * @return -- int[]
     */
    public int[] twoSumRecur(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    /*
     * @author -- gatsby
     * @description -- 两数之和，排序然后二分
     * @data -- 2022/2/2
     * @param -- [nums, target]
     * @return -- int[]
     */
    public int[] twoSumBS(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{0, 0};
    }
}