package com.gatsby.utils;

/**
 * @ClassName: SortUtil
 * @Description: 排序类
 * @author: Gatsby
 * @date: 2022/7/25 15:03
 */

public class SortUtil {
    /**
     * @MethodName:  quickSort
     * @Parameter: [nums, begin, end]
     * @Return void
     * @Description: 快速排序
     * @author: Gatsby
     * @date:  2022/7/25 15:20
     */
    public static void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int pivot = nums[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && nums[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while (i < j && nums[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[j] = pivot;
            quickSort(nums, begin, j - 1);
            quickSort(nums, j + 1, end);
        }
    }
}


