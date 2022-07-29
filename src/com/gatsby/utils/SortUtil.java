package com.gatsby.utils;

import java.util.Arrays;

/**
 * @ClassName: SortUtil
 * @Description: 排序类
 * @author: Gatsby
 * @date: 2022/7/25 15:03
 */

public class SortUtil {
    static int[] tmp;

    /**
     * @MethodName: quickSort
     * @Parameter: [nums, begin, end]
     * @Return void
     * @Description: 快速排序
     * @author: Gatsby
     * @date: 2022/7/25 15:20
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


    public static int[] mergeSort(int[] nums) {
        tmp = new int[nums.length];
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    private static void merge(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (right + left) >> 1;
        merge(nums, left, mid);
        merge(nums, mid + 1, right);

        int i = left;
        // 如果数组只有一个那就不会操作了
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[count++] = nums[i++];
            } else {
                tmp[count++] = nums[j++];
            }
        }
        // System.out.println(Arrays.toString(tmp));
        if (i <= mid) {
            System.arraycopy(nums, i, tmp, count, mid - i + 1);
        }

        if (j <= right) {
            System.arraycopy(nums, j, tmp, count, right - j + 1);
        }
        System.arraycopy(tmp, 0, nums, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 5, 3, 8, 3, 1, 6, 3, 4};
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}


