package com.gatsby;

/**
 * @ClassName: _1539KthMissingPositiveNumber
 * @Description: leetcode 1539 第k个缺失的正整数
 * @author: Gatsby
 * @date: 2022/5/10 22:00
 */

public class _1539KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }
}


