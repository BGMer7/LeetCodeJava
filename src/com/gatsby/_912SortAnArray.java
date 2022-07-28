package com.gatsby;

import com.gatsby.utils.SortUtil;

/**
 * @ClassName: _912SortAnArray
 * @Description: leetcode 912 排序数组
 * @author: Gatsby
 * @date: 2022/7/25 15:23
 */

public class _912SortAnArray {
    public int[] sortArray(int[] nums) {
        SortUtil.quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}



