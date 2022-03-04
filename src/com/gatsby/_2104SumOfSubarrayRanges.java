package com.gatsby;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _2104SumOfSubarrayRanges
 * @Description: leetcode 2104 子数组范围和
 * @author: Gatsby
 * @date: 2022/3/4 10:27
 */

public class _2104SumOfSubarrayRanges {
    /**
     * @MethodName: subArrayRanges
     * @Parameter: [nums]
     * @Return long
     * @Description: 暴力解法，直接两层循环：
     * 第一层循环，遍历i，刚开始的时候max和min都是相等的
     * 然后递增j，一直到数组尾端，用max和min维护这个子数组中的最大值和最小值
     * 每次j+1前进一步，就更新max和min，max-min得到差值
     * sum累加
     * @author: Gatsby
     * @date: 2022/3/4 10:34
     */
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < n; ++j) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }

    public long subArrayRangesStack(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        long maxSum = 0;
        long minSum = 0;
        int n = nums.length;
        for (int i = 0; i <= n; ++i) {
            // 其实一步一步拆分开来就是先获取到单调栈中的保存的那个数值最大的元素的index
            // 因为peekLast有可能会返回一个空指针，所以理论上来说需要将peekLast之前先保证stack非空
            // 多加了两个变量只是为了代码的可读性更好，实际上更严谨的写法应该是放在while循环中
            while (!stack.isEmpty() && (i == n || nums[stack.peekLast()] < nums[i])) {
                int maxIndex = stack.pollLast();
                // 获取到maxIndex意味着在这个maxIndex之前的最大值都是由nums[maxIndex]保持的
                // 这一部分的maxSum求和就是(i-maxIndex)*nums[maxIndex]
                // 如果采用整个乘法算式算出结果之后再转换成long类型，会有精度损失
                // 必须要在一开始先将nums[maxIndex]转换为long类型，这样整个算式的每一步都是long类型
                maxSum += (long) nums[maxIndex] * (i - maxIndex) * (maxIndex - (stack.isEmpty() ? -1 : stack.peekLast()));
            }
            stack.offerLast(i);
        }
        stack = new ArrayDeque<>();
        for (int i = 0; i <= n; ++i) {
            // 其实一步一步拆分开来就是先获取到单调栈中的保存的那个数值最大的元素的index
            // 因为peekLast有可能会返回一个空指针，所以理论上来说需要将peekLast之前先保证stack非空
            // 多加了两个变量只是为了代码的可读性更好，实际上更严谨的写法应该是放在while循环中
            while (!stack.isEmpty() && (i == n || nums[stack.peekLast()] > nums[i])) {
                int minIndex = stack.pollLast();

                // 获取到maxIndex意味着在这个maxIndex之前的最大值都是由nums[maxIndex]保持的]
                // 这一部分的maxSum求和就是(i-maxIndex)*nums[maxIndex]
                minSum += (long) nums[minIndex] * (i - minIndex) * (minIndex - (stack.isEmpty() ? -1 : stack.peekLast()));
            }
            stack.offerLast(i);
        }
        return maxSum - minSum;
    }

    public static void main(String[] args) {
        _2104SumOfSubarrayRanges solution = new _2104SumOfSubarrayRanges();
        System.out.println(solution.subArrayRangesStack(new int[]{1, 2, 3, 4, 5, 6}));
    }

}


