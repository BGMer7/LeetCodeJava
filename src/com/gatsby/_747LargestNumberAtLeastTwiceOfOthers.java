package com.gatsby;

/**
 * @ClassName: _747LargestNumberAtLeastTwiceOfOthers
 * @Description: leetcode 747 最大的数字要比所有数字都大两倍
 * @author: Gatsby
 * @date: 2022/1/13 12:42
 */

public class _747LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (Math.max(max, nums[i]) == num) {
                maxIndex = i;
                secondMax = max;
                max = num;
            } else if (Math.max(secondMax, num) == num) {
                secondMax = num;
            }
        }
        if (max >= 2 * secondMax) {
            return maxIndex;
        }
        return -1;
    }
}


