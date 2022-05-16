package com.gatsby;

/**
 * @ClassName: _153FindMinimumInRotatedSortedArray
 * @Description: leetcode 153 寻找旋转排序数组中的最小值
 * @author: Gatsby
 * @date: 2022/5/16 10:52
 */

public class _153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else left = mid + 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        _153FindMinimumInRotatedSortedArray solution = new _153FindMinimumInRotatedSortedArray();
        System.out.println(solution.findMin(nums));
    }
}


