package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _977SquaresOfSortedArray
 * @Description: leetcode 977 有序数组的平方
 * @author: Gatsby
 * @date: 2022/5/6 19:15
 */

public class _977SquaresOfSortedArray {
    public int[] sortedSquaresBrute(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        if (nums[0] > 0) {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }

        int[] res = new int[n];
        if (nums[n - 1] < 0) {
            for (int i = 0; i < nums.length; ++i) {
                res[n - 1 - i] = nums[i] * nums[i];
            }
            return res;
        }

        // 双指针比较绝对值
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; --i) {
            int num = 0;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                num = nums[left];
                left++;
            } else {
                num = nums[right];
                right--;
            }
            res[i] = num * num;
        }
        return res;
    }
}


