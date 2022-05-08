package com.gatsby;

/**
 * @ClassName: _189RotateArray
 * @Description: leetcode 189 轮转数组
 * @author: Gatsby
 * @date: 2022/5/7 6:39
 */

public class _189RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // k有可能大于数组长度
        int[] arr = new int[n];
        System.arraycopy(nums, n - k, arr, 0, k);
        System.arraycopy(nums, 0, arr, k, n - k);
        System.arraycopy(arr, 0, nums, 0, n);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateReverse(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 4, arr, 0, 3);
        _189RotateArray solution = new _189RotateArray();
        solution.rotate(nums, 3);
    }
}


