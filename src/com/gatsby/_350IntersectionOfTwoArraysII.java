package com.gatsby;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: _350IntersectionOfTwoArraysII
 * @Description: leetcode 350 两个数组的交集II
 * @author: Gatsby
 * @date: 2022/5/7 10:08
 */

public class _350IntersectionOfTwoArraysII {
    /**
     * @MethodName: intersect
     * @Parameter: [nums1, nums2]
     * @Return int[]
     * @Description: 这种方法是不严谨的，当出现[1,2,2,1]/[2]这种情况的时候，结果会是[2,2]，需要记录出现次数
     * @author: Gatsby
     * @date: 2022/5/7 10:25
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        List<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for (int num : nums1) {
            if (nums2List.contains(num)) {
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); ++i) {
            res[i] = intersection.get(i);
        }
        return res;
    }

    public int[] intersectHash(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        for (int num : nums1) {
            int count = count1.getOrDefault(num, 0);
            count1.put(num, count + 1);
        }

        for (int num : nums2) {
            int count = count2.getOrDefault(num, 0);
            count2.put(num, count + 1);
        }

        List<Integer> intersection = new ArrayList<>();

        Set<Integer> keys1 = count1.keySet();
        Set<Integer> keys2 = count2.keySet();

        for (int key1 : keys1) {
            int count = 0;
            if (keys2.contains(key1)) {
                count = Math.min(count1.get(key1), count2.get(key1));
            }
            for (int i = 0; i < count; ++i) {
                intersection.add(key1);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); ++i) {
            res[i] = intersection.get(i);
        }
        return res;
    }

    public int[] intersectSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int[] intersection = new int[Math.max(nums1.length, nums2.length)];
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersection[i] = nums1[p1];
                i++;
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, i);
    }

    public static void main(String[] args) {
        _350IntersectionOfTwoArraysII solution = new _350IntersectionOfTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        solution.intersectHash(nums1, nums2);
    }
}


