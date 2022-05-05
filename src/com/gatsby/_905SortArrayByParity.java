package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/4/28
 * @description -- leetcode 905 排序排序数组
 */


public class _905SortArrayByParity {
    private boolean even(int n) {
        return n % 2 != 1;
    }

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && even(nums[left])) {
                left++;
            }
            while (left < right && !even(nums[right])) {
                right--;
            }
            if (left < right) {
                int leftN = nums[left];
                nums[left] = nums[right];
                nums[right] = leftN;
                left++;
                right--;
            }

        }
        return nums;
    }
}