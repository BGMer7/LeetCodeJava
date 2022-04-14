package com.gatsby.tencent.array;

/**
 * @ClassName: _11ContainerWithMostWater
 * @Description: leetcode 11 盛最多水的容器
 * @author: Gatsby
 * @date: 2022/4/13 15:18
 */

public class _11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int h = Math.min(leftHeight, rightHeight);
            res = Math.max(res, h * (right - left));
            if (h == leftHeight) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}


