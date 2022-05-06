package com.gatsby;

/**
 * @ClassName: _852PeakIndexInAMountainArray
 * @Description: leetcode 852 山脉数组的顶峰索引
 * @author: Gatsby
 * @date: 2022/5/6 18:34
 */

public class _852PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid+1]) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}


