package com.gatsby.tencent.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _78Subsets
 * @Description: leetcode 78 子集
 * @author: Gatsby
 * @date: 2022/3/20 23:00
 */

public class _78Subsets {
    private List<List<Integer>> res;
    // 为了能使用removeLast()方法，并且解除

    private LinkedList<Integer> track;

    private void helper(List<List<Integer>> res, int[] nums, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<>(track));
            return;
        }

        res.add(new ArrayList<>(track));
        for (int i = index; i < n; ++i) {
            track.add(nums[i]);
            helper(res, nums, i + 1, n);
            track.removeLast();
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        this.track = new LinkedList<>();

        helper(res, nums, 0, nums.length);
        return res;
    }
}


