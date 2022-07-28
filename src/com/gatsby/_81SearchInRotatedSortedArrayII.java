package com.gatsby;

/**
 * @ClassName: _81SearchInRotatedSortedArrayII
 * @Description:
 * @author: Gatsby
 * @date: 2022/7/25 14:26
 */

public class _81SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[left] == nums[mid]) {
                ++left;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}


