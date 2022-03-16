package com.gatsby.lcp;

/**
 * @author -- gatsby
 * @date -- 2022/1/12
 * @description -- LCP 12 小张刷题计划
 * 前置题：LeetCode 410 分割数组的最大值 hard
 */


public class LCP12CodingPlan {
    private boolean check(int[] nums, int max, int days) {
        int sum = 0;
        int cnt = 1;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            if (sum + num - maxNum > max) {
                cnt++;
                sum = num;
                maxNum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= days;
    }

    public int minTime(int[] time, int m) {
        if (m > time.length) return 0;
        // 在410中，因为最小的容量应该是最大元素的值，但是在这道题中不是的
        // 如果某一天只做一道题呢？那么这道题是可以交给场外援助的，也就是说，这里的left是可以为0的
        int left = 0;
        int right = 0;
        for (int t : time) {
            right += t;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(time, mid, m)) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        LCP12CodingPlan solution = new LCP12CodingPlan();
        int[] time = {1, 2, 3};
        int m = 2;
        System.out.println(solution.minTime(time, m));
    }
}