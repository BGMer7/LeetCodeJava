package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/4/18
 * @description -- leetcode 386 字典序排数
 */


public class _386LexicographicalNumbers {
    private List<Integer> res;

    private void dfs(int num, int n) {
        if (num > n) return;
        res.add(num);
        for (int i = 0; i < 10; ++i) {
            dfs(10 * num + 1, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n);
        }
        return res;
    }
}