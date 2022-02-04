package com.gatsby;

import java.util.Arrays;

/**
 * @author -- gatsby
 * @date -- 2022/2/4
 * @description -- leetcode 88 合并两个有序数组
 */


public class _88MergeSortedArray {
    /*
     * @author -- gatsby
     * @description -- 直接合并然后排序
     * @data -- 2022/2/4
     * @param -- [nums1, m, nums2, n]
     * @return -- void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         * @author -- gatsby
         * @description --
         * @data -- 2022/2/4
         * @param -- [nums1, m, nums2, n]
         * @return -- void
         */
        for (int i = m, j = 0; i < m + n && j < n; ++i, ++j) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    /*
     * @author -- gatsby
     * @description -- 双指针，从前往后，需要一个临时变量，在这里是res
     * @data -- 2022/2/4
     * @param -- [nums1, m, nums2, n]
     * @return -- void
     */
    public void merge2Ptr(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0;
        int ptr2 = 0;
        int[] res = new int[m + n];
        while (ptr1 != m || ptr2 != n) {
            int pos = ptr1 + ptr2 + 1;
            if (ptr1 == m) {
                res[pos] = nums2[ptr2++];
            } else if (ptr2 == n) {
                res[pos] = nums1[ptr1++];
            } else {
                if (nums1[ptr1] <= nums2[ptr2]) {
                    res[pos] = nums1[ptr1++];
                } else {
                    res[pos] = nums2[ptr2++];
                }
            }
        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }

    /*
     * @author -- gatsby
     * @description -- 逆向双指针，不仅利用起来了两个已经排序了的数组的性质
     * 也利用到了nums1的剩余空间
     * @data -- 2022/2/4
     * @param -- [nums1, m, nums2, n]
     * @return -- void
     */
    public void merge2PtrBackward(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;
        while (ptr1 >= 0 || ptr2 >= 0) {
            int pos = ptr1 + ptr2 - 1;
            if (ptr1 == -1) {
                nums1[pos] = nums2[ptr2--];
            } else if (ptr2 == -1) {
                nums1[pos] = nums1[ptr1--];
            } else if (nums1[ptr1] > nums2[ptr2]) {
                nums1[pos] = nums1[ptr1--];
            } else {
                nums1[pos] = nums2[ptr2--];
            }
        }
    }
}