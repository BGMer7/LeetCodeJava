package com.gatsby;

/**
 * @ClassName: _34FindFirstAndLastPositionInSortedArray
 * @Description: leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 * @author: Gatsby
 * @date: 2022/4/6 16:51
 */

public class _34FindFirstAndLastPositionInSortedArray {
    /**
     * @MethodName:  searchRange
     * @Parameter: [nums, target]
     * @Return int[]
     * @Description: 找到任意一个target之后，向前和向后寻找，直到不一样
     * @author: Gatsby
     * @date:  2022/4/6 20:31
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int first = left;
        int last = left;
        while (first - 1 >= 0 && nums[first - 1] == nums[left]) {
            first--;
        }
        while (last + 1 < nums.length && nums[last + 1] == nums[left]) {
            last++;
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        _34FindFirstAndLastPositionInSortedArray solution = new _34FindFirstAndLastPositionInSortedArray();
        int[] nums = new int[] {1,2,3};
        System.out.println(solution.searchRange(nums, 2));
    }
}


