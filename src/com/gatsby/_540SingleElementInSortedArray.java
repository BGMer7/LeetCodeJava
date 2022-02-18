package com.gatsby;

/**
 * @ClassName: _540SingleElementInSortedArray
 * @Description: leetcode 540 有序数组中的单一元素
 * @author: Gatsby
 * @date: 2022/2/14 12:47
 */

public class _540SingleElementInSortedArray {
    /**
     * @MethodName:  singleNonDuplicate
     * @Parameter: [nums]
     * @Return int
     * @Description: 直接把所有的都异或一遍
     * 因为自己和自己异或的结果是0
     * 但是直接异或没有用到sorted的这个性质，
     * 但是如果用过位运算，这是最容易想到的办法
     * @author: Gatsby
     * @date:  2022/2/14 13:35
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];

        int res = nums[0];
        for (int i = 1; i < n; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}


