package com.gatsby;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _2208MinimumOperationsToHalveArraySum
 * @Description: leetcode 2208 将数组和减半的最少操作次数
 * @author: Gatsby
 * @date: 2022/7/19 13:17
 */

public class _2208MinimumOperationsToHalveArraySum {
    public int halveArray(int[] nums) {
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num : nums) {
            priorityQueue.add(num);
            sum += num;
        }
        double half = (double) sum / 2;
        double currentSum = sum;
        int count = 0;
        System.out.println(sum);
        while (half < currentSum) {
            int max = priorityQueue.poll();
            max /= 2;
            currentSum -= max;
            priorityQueue.add(max);
            count++;
            System.out.println(currentSum);
        }
        return count;
    }
}


