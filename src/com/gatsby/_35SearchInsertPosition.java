package com.gatsby;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: _35SearchInsertPosition
 * @Description: leetcode 35 搜索插入位置
 * @author: Gatsby
 * @date: 2022/5/5 16:47
 */

public class _35SearchInsertPosition {
    public int searchInsertBrute(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(target);
        Collections.sort(list);
        return list.indexOf(target);
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}


