package com.gatsby;

/**
 * @ClassName: _167TwoSumII
 * @Description: leetcode 167 两数之和 有序
 * @author: Gatsby
 * @date: 2022/5/7 7:21
 */

public class _167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int n = numbers.length;
        int right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}


