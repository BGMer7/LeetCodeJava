package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 969 煎饼排序
 */


public class _969PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int[] idxs = new int[n + 10];
        for (int i = 0; i < n; i++) idxs[arr[i]] = i;
        List<Integer> res = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int idx = idxs[i];
            if (idx == i - 1) continue;
            if (idx != 0) {
                res.add(idx + 1);
                reverse(arr, 0, idx, idxs);
            }
            res.add(i);
            reverse(arr, 0, i - 1, idxs);
        }
        return res;
    }

    void reverse(int[] arr, int i, int j, int[] idxs) {
        while (i < j) {
            idxs[arr[i]] = j;
            idxs[arr[j]] = i;
            int c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
    }

    public static void main(String[] args) {
        _969PancakeSorting solution = new _969PancakeSorting();
        System.out.println(solution.pancakeSort(new int[]{4,3,2,1}));
    }

}