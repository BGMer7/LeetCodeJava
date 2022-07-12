package com.gatsby;

/**
 * @ClassName: _231PowerOfTwo
 * @Description: leetcode 231 2的幂
 * @author: Gatsby
 * @date: 2022/5/17 11:23
 */

public class _231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // lowbit()
        return n>0 && (n & (n-1)) == 0;

        // if (n <= 0) return false;
        // if (n == 1) return true;
        // while (n / 2 > 0) {
        //     if (n % 2 != 0) return false;
        //     n /= 2;
        // }
        // return true;
    }
}


