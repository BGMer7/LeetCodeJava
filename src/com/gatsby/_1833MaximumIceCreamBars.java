package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _1833MaximumIceCreamBars
 * @Description: 1833. Maximum Ice Cream Bars
 * @author: Gatsby
 * @date: 2022/7/29 11:57
 */

public class _1833MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int i = 0;
        while (i < costs.length && coins - costs[i] > 0) {
            coins -= costs[i++];
            count++;
        }
        return count;
    }
}


