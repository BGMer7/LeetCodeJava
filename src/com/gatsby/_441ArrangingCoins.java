package com.gatsby;

/**
 * @ClassName: _441ArrangingCoins
 * @Description: leetcode 441 排列硬币
 * @author: Gatsby
 * @date: 2022/5/10 21:44
 */

public class _441ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}


