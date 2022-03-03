package com.gatsby.tencent.array;

/**
 * @author -- gatsby
 * @date -- 2022/3/3
 * @description -- leetcode 26 删除排序数组中的重复值
 */


public class _26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}