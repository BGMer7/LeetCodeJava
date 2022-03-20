package com.gatsby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: _46Permutations
 * @Description: leetcode 46 全排列
 * @author: Gatsby
 * @date: 2022/3/19 21:39
 */

public class _46Permutations {
    private void helper(List<Integer> list, List<List<Integer>> res, int index, int n) {
        if (index == n) {
            res.add(new ArrayList(list));
        }
        for (int i = index; i < n; ++i) {
            Collections.swap(list, index, i);
            helper(list, res, index + 1, n);
            Collections.swap(list, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        helper(list, res, 0, nums.length);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(numsList.toString());
        Collections.swap(numsList, 1, 3);
        System.out.println(numsList.toString());

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a = numsList;
        for (int i = 0; i < 4; ++i) {
            res.add(a);
        }
        System.out.println(res.toString());
        // [[1, 4, 3, 2], [1, 4, 3, 2], [1, 4, 3, 2], [1, 4, 3, 2]]
        numsList.add(5);
        // a引用numsList
        // res引用a
        // res也在引用numsList
        // 所以一旦numsList改变，res也会改变
        System.out.println(res.toString());
        // [[1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5]]

        res.clear();
        for (int i = 0; i < 5; ++i) {
            res.add(new ArrayList<>(a));
        }
        System.out.println(res.toString());
        // [[1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5]]
        numsList.add(6);
        System.out.println(res.toString());
        // [[1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5], [1, 4, 3, 2, 5]]
    }
}


