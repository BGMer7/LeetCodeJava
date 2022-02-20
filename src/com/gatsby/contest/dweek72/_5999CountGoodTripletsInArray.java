package com.gatsby.contest.dweek72;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 第72周双周赛 5999
 * Count Good Triplets in an Array
 * https://leetcode-cn.com/problems/count-good-triplets-in-an-array/
 * You are given two 0-indexed arrays nums1 and nums2 of length n,
 * both of which are permutations of [0, 1, ..., n - 1].
 *
 * A good triplet is a set of 3 distinct values which are present in increasing order by position both in nums1 and nums2.
 * In other words, if we consider pos1v as the index of the value v in nums1 and pos2v as the index of the value v in nums2,
 * then a good triplet will be a set (x, y, z) where 0 <= x, y, z <= n - 1,
 * such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
 *
 * Return the total number of good triplets.
 */


public class _5999CountGoodTripletsInArray {
    /*
     * @author -- gatsby
     * @description -- 算是暴力法吧，答案是正确的，但是case超时
     * @data -- 2022/2/20
     * @param -- [nums1, nums2]
     * @return -- long
    */
    public long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> index1 = new HashMap<>();
        Map<Integer, Integer> index2 = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; ++i) {
            index1.put(nums1[i], i);
            index2.put(nums2[i], i);
        }

        long res = 0;
        for (int i = 0; i < n - 2; ++i) {
            int firstIndex1 = i;
            int firstIndex2 = index2.get(nums1[i]);
            for (int j = i + 1; j < n - 1; ++j) {
                int secondIndex1 = j;
                int secondIndex2 = index2.get(nums1[j]);
                if (firstIndex2 > secondIndex2) continue;
                for (int k = j + 1; k < n; ++k) {
                    int thirdIndex1 = k;
                    int thirdIndex2 = index2.get(nums1[k]);
                    if (secondIndex2 > thirdIndex2) continue;
                    else res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,0,1,3,2};
        int[] nums2 = {4,1,0,2,3};
        _5999CountGoodTripletsInArray solution = new _5999CountGoodTripletsInArray();
        System.out.println(solution.goodTriplets(nums1, nums2));
    }
}