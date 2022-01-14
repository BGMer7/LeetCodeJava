package com.gatsby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author -- gatsby
 * @date -- 2022/1/14
 * @description -- leetcode 373 找到数组中的最小的k个pair
 */


public class _373FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(k, nums1.length); ++i) {
            priorityQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();
            res.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));

            if (++pair[1] < nums2.length) {
                priorityQueue.offer(pair);
            }
        }
        return res;
    }
}