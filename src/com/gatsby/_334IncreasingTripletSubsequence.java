package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/11
 * @description -- leetcode 334
 */


public class _334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int min = nums[0];
        int mid = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] > min) {
                mid = nums[i];
            } else {
                mid = min;
                min = nums[i];
            }
        }
        return false;
    }

    public boolean isIncreasingTriplet(int[] nums) {
        final int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] minInLeft = new int[n];
        int[] maxInRight = new int[n];
        minInLeft[0] = nums[0];
        maxInRight[n - 1] = nums[n - 1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; ++i) {
            min = Math.min(nums[i - 1], min);
            minInLeft[i] = min;
        }

        for (int i = n - 2; i > 0; --i) {
            max = Math.max(nums[i + 1], max);
            maxInRight[i] = max;
        }

        for (int i = 0; i < n - 1; ++i) {
            if (minInLeft[i] < nums[i] && nums[i] < maxInRight[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}