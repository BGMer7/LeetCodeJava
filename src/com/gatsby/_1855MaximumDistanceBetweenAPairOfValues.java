package com.gatsby;

/**
 * @ClassName: _1855MaximumDistanceBetweenAPairOfValues
 * @Description:
 * @author: Gatsby
 * @date: 2022/5/15 18:54
 */

public class _1855MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (left < n && right < m) {
            if (nums1[left] > nums2[right]) {
                ++left;
            }
            ++right;
        }
        return Math.max(right - left - 1, 0);
    }
}


