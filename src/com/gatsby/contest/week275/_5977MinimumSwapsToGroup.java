package com.gatsby.contest.week275;

/**
 * @author -- gatsby
 * @date -- 2022/1/9
 * @description -- 周赛275 最少交换次数来组合所有的1
 */

// https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii/
public class _5977MinimumSwapsToGroup {
    // 创建一个环形数组，方法就是直接创建一个长度为原长度两倍的数组，每个值都重新赋值，直到开头和结尾都是同一个元素
    private int[] makeCircle(int[] nums) {
        int[] circle = new int[nums.length * 2];
        for (int i = 0; i < nums.length; ++i) {
            circle[i] = nums[i];
            circle[nums.length + i] = nums[i];
        }
        return circle;
    }

    private int zeroCntInArray(int[] nums, int left, int right) {
        int cnt = 0;
        for (int i = left; i < right; ++i) {
            cnt += nums[i];
        }
        return right - left - cnt;
    }

    public int minSwaps(int[] nums) {
        int[] circle = makeCircle(nums);
        int oneCnt = 0;
        for (int i : nums)
            oneCnt += i;
        int res = nums.length;
        for (int i = 0; i + oneCnt < circle.length; ++i) {
            int zero = zeroCntInArray(circle, i, i + oneCnt);
            System.out.println(zero);
            res = Math.min(zero, res);
        }
        return res;
    }

    public int minSwapsV2(int[] nums) {
        int[] circle = makeCircle(nums);
        int oneCnt = 0;
        for (int i : nums)
            oneCnt += i;
        if (oneCnt == 0) return 0;
        int res = nums.length;
        int cnt = 0;
        for (int i = 0; i < circle.length; ++i) {
            if (circle[i] == 1) {
                cnt++;
            }
            if (i >= oneCnt - 1) {
                res = Math.min(oneCnt - cnt, res);
                cnt -= circle[i - oneCnt + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _5977MinimumSwapsToGroup solution = new _5977MinimumSwapsToGroup();
        int[] nums = {0, 0, 0};
        System.out.println(solution.minSwapsV2(nums));
    }
}