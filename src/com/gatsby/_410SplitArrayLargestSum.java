package com.gatsby;

/**
 * @ClassName: _410SplitArrayLargestSum
 * @Description: leetcode 410 分割数组的最大值
 * 衍生题目 LCP 12 小张刷题计划
 * 类似思路题目：875 1011
 * @author: Gatsby
 * @date: 2022/3/15 16:41
 */

public class _410SplitArrayLargestSum {
    /**
     * @MethodName: check
     * @Parameter: [nums, max, groups]
     * nums: 原始数组
     * max: 每一组的最大和不能超过的数值
     * groups: 原计划分成的组的数量
     * @Return boolean
     * @Description: 实现功能：假设每组之和不能超过max，超过max就新分一组
     * 那么整个nums就需要遍历找出一共需要分多少组
     * 以当前的max来计算的话，超过max就cnt++，最终得到的cnt需要和计划中的groups数量比对
     * 如果实际分出来的组的数量，小于groups，说明还有优化空间
     * @author: Gatsby
     * @date: 2022/3/15 17:10
     */
    private boolean check(int[] nums, int max, int groups) {
        int sum = 0;
        int cnt = 1;
        for (int num : nums) {
            if (sum + num > max) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= groups;
    }

    /**
     * @MethodName: splitArray
     * @Parameter: [nums, m]
     * @Return int
     * @Description: 二分法
     * 其实如果单纯说二分法，可能有点难以理解，毕竟印象中的二分法可能更偏向是一种横向比较
     * 也就是说一个横向的数组，从左到右不断缩小区间，直到找出最合适的那个结果
     * 但是我们可以把二分法理解成，left当作是一种最差的结果，right当作是另一种最差的结果
     * 然后将这两种最差的结果都不断优化，直到达到平衡，那么此时的结果就是一个最好的结果
     * <p>
     * 将这个思路代入到这道题来说
     * 已知我们需要找到一个max值，这个max值可以看作是一个容器的容量
     * 现在整个数组的和，需要若干个容器来装载
     * 考虑两种极端的情况：
     * 1. 有无穷多的容器，有多少元素就用多少个容器，那么此时的容器容量就是所有元素中最大的那个
     * 因为只需要保证通用容器可以装载最大的那个，其余的元素都是可以装下的
     * 2. 只有一个容器，那么这个容器的容量就是所有元素之和
     * 此时我们已经找到了left和right，通过一次遍历将left和right都计算出来
     * left就是最大元素的值，right就是元素之和
     * <p>
     * 获取到了left和right之后，其实要做的一件很简单的事情就是
     * 一次次实验，看看是否符合题意（我也没有想到原来是这么粗暴的方式...
     * @author: Gatsby
     * @date: 2022/3/15 17:18
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }

        while (left < right) {
            // 加减运算的优先级居然是高于位运算的...涨知识
            int mid = left + ((right - left) >> 1);
            // 如果还有优化空间，那么容量为mid时候的容器还是太浪费了，还可以减小容量并且满足小于groups
            if (check(nums, mid, m)) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }
}


