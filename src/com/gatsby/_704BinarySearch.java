package com.gatsby;

/**
 * @ClassName: _704BinarySearch
 * @Description: leetcode 704 二分查找
 * @author: Gatsby
 * @date: 2022/4/6 15:12
 */

public class _704BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 有可能会出现不存在target的情况
        return nums[left] == target ? left : -1;
    }
}


