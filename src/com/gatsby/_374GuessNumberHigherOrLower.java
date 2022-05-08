package com.gatsby;

/**
 * @ClassName: _374GuessNumberHigherOrLower
 * @Description: leetcode 374 猜数字大小
 * @author: Gatsby
 * @date: 2022/5/5 15:29
 */

public class _374GuessNumberHigherOrLower {
    private int pick;

    public _374GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }

    private int guess(int n) {
        return n < pick ? -1 : (n == pick) ? 0 : 1;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


