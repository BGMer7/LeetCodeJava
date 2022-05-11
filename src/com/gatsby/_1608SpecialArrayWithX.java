package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _1608SpecialArrayWithX
 * @Description: leetcode 1608 特殊数组的特征值
 * @author: Gatsby
 * @date: 2022/5/11 14:40
 */

public class _1608SpecialArrayWithX {
    private int[] nums;
    private int n;

    private int greaterThan(int x) {
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= x) count++;
        }
        return count - x;
    }

    public int specialArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        Arrays.sort(nums);
        int left = nums[0];
        int right = nums[n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (greaterThan(mid) == 0) return mid;
            else if (greaterThan(mid) > 0) left = mid + 1;
            else right = mid - 1;
        }
        if (left == 0 || greaterThan(left) != 0) return -1;
        return left;
    }
}


