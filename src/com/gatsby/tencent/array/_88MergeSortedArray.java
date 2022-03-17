package com.gatsby.tencent.array;

/**
 * @ClassName: _88MergeSortedArray
 * @Description: leetcode 88 合并两个有序数组
 * @author: Gatsby
 * @date: 2022/3/17 21:40
 */

public class _88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0)
            nums1[cur--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}


