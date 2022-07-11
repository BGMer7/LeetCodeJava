package com.gatsby;

/**
 * @ClassName: _1470ShuffleTheArray
 * @Description: leetcode 1470 重新排列数组
 * @author: Gatsby
 * @date: 2022/7/11 10:44
 */

public class _1470ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int x = 0;
        int y = n;
        for (int i = 0; i < 2 * n; ) {
            res[i++] = nums[x++];
            res[i++] = nums[y++];
        }
        return res;
    }
}


