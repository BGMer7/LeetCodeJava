package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1218LongestArithmeticSubsequenceOfGivenDifference
 * @Description: 1218. 最长定差子序列
 * @author: Gatsby
 * @date: 2022/7/15 10:17
 */

public class _1218LongestArithmeticSubsequenceOfGivenDifference {
    // 动态规划：O(n2)
    public int longestSubsequenceOn2(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        int longest = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    longest = Math.max(longest, dp[i]);
                }
            }
        }
        return longest;
    }

    // 动态规划，直接构造一个hash映射，就避免了数组没有办法将index和value对应存储的问题
    // hash表中的index直接记录arr中的数值，这样就和difference挂钩
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for (int i = 0; i < arr.length; ++i) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
            longest = Math.max(longest, dp.get(arr[i]));
        }
        return longest;
    }
}


