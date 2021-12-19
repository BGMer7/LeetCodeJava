package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2021/12/19
 * @description -- leetcode 997 寻找小镇法官 图
 */


public class _997FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] relation : trust) {
            ++inDegree[relation[1]];
            ++outDegree[relation[0]];
        }

        for (int i = 1; i <= n; ++i) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}