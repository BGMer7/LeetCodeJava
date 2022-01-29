package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/27
 * @description -- leetcode 1025 除数博弈
 */


public class _1025DivisorGame {
    /*
    case:
    N=1 x=null return True
    N=2 x=1 2%1==0 -> N=1 return false
    N=3 x=2 3%1!=0 / N=3 x=1 3%1==0 -> N=2 x=1 2%1==0 -> return True
     */
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        dp[2] = false;

        for (int i = 3; i <= n; ++i) {
            // 开始选x，因为首先要满足0<x<N，且N%x==0这个条件
            // 所以把从0到N的所有数字都遍历，找到因数
            for (int j = 1; j < i; ++j) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}