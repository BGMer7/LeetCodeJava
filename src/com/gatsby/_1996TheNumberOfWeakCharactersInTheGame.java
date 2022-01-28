package com.gatsby;

import java.util.Arrays;

/**
 * @author -- gatsby
 * @date -- 2022/1/28
 * @description -- leetcode 1996 游戏中弱角色的数量
 */


public class _1996TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        int res = 0;
        for (int i = 0, maxDefense = -1, n = properties.length; i < n; ) {
            int j = i, cur = maxDefense;
            maxDefense = Math.max(maxDefense, properties[i][1]);
            for (; j < n && properties[j][0] == properties[i][0]; j++)
                if (properties[j][1] < cur)
                    res++;
            i = j;
        }
        return res;
    }
}