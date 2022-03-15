package com.gatsby.lcp;

/**
 * @ClassName: LCP01GuessNumbers
 * @Description: LCP 01. 猜数字
 * @author: Gatsby
 * @date: 2022/3/15 13:38
 */

public class LCP01GuessNumbers {
    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; ++i)
            res += (guess[i] == answer[i] ? 1 : 0);

        return res;
    }
}


