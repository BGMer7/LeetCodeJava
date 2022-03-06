package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/3/6
 * @description -- leetcode 2100 适合打劫银行的日子
 */


public class _2100FindGoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        if (n <= 2 * time) return new ArrayList<Integer>();
        int[] increase = new int[n];
        int[] decrease = new int[n];
        int min = security[0];
        int increaseIndex = 0;
        int decreaseIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (security[i] > min) {
                increaseIndex = 0;
            }
            increase[i] = increaseIndex++;
            min = security[i];
        }
        min = security[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            if (security[i] > min) {
                decreaseIndex = 0;
            }
            decrease[i] = decreaseIndex++;
            min = security[i];
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (increase[i] >= time && decrease[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _2100FindGoodDaysToRobBank solution = new _2100FindGoodDaysToRobBank();
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        System.out.println(solution.goodDaysToRobBank(security, time));
    }
}