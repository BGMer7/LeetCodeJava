package com.gatsby.lcp;

import java.util.Arrays;

/**
 * @ClassName: LCP18BreakfastCombination
 * @Description: LCP 18. 早餐组合
 * @author: Gatsby
 * @date: 2022/3/15 13:47
 */

public class LCP18BreakfastCombination {
    private static int mod = 1000000007;

    /**
     * @MethodName: lastSmaller
     * @Parameter: [nums, n]，其中nums是已经排序的
     * @Return int
     * @Description: 返回小于n的个数，O(n)时间复杂度
     * @author: Gatsby
     * @date: 2022/3/15 13:50
     */
    private int countSmaller(int[] nums, int n) {
        int cnt = 0;
        for (int num : nums) {
            if (num <= n) cnt++;
            else return cnt;
        }
        return cnt;
    }

    private static int upperBinarySearch(int[] nums, int n) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long res = 0;
        for (int drink : drinks) {
            if (drink >= x) break;
            long sta = upperBinarySearch(staple, x - drink);
            res += sta;
            res %= mod;
        }
        return (int) res % mod;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(upperBinarySearch(nums, 4));
        int[] staple = {10, 20, 5};
        int[] drinks = {5, 5, 2};

        LCP18BreakfastCombination solution = new LCP18BreakfastCombination();
        System.out.println(solution.breakfastNumber(staple, drinks, 15));
    }
}


