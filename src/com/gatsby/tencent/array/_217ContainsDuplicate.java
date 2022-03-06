package com.gatsby.tencent.array;

import java.util.Arrays;

/**
 * @author -- gatsby
 * @date -- 2022/3/5
 * @description -- leetcode 217 存在重复元素I
 */


public class _217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        Arrays.sort(nums);
        int slow = 0;
        int fast = slow + 1;
        while (fast < nums.length) {
            if (nums[slow++] == nums[fast++]) return true;
        }
        return false;
    }
}