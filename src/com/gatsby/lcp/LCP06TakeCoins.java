package com.gatsby.lcp;

/**
 * @ClassName: LCP06TakeCoins
 * @Description: LCP 06. 拿硬币
 * @author: Gatsby
 * @date: 2022/3/15 13:41
 */

public class LCP06TakeCoins {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += Math.ceil((double) coin / 2);
            // res += (coin+1)/2;
        }
        return res;
    }
}


