package com.gatsby;

/**
 * @ClassName: _762PrimeNumberOfSetBitsInBinaryRepresentation
 * @Description: leetcode 762 二进制表示中质数个计算置位
 * 计算置位位数 就是二进制表示中 1 的个数。
 * @author: Gatsby
 * @date: 2022/4/5 10:24
 */

public class _762PrimeNumberOfSetBitsInBinaryRepresentation {
    private int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; ++i) {
            if (n % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; ++i) {
            if (isPrime(countSetBits(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * @MethodName: countPrimeSetBitsAnd
     * @Parameter: [left, right]
     * @Return int
     * @Description: 直接按位与
     * 因为right<=10^6<2^20
     * @author: Gatsby
     * @date: 2022/4/5 11:01
     */
    public int countPrimeSetBitsAnd(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            // bitCount: the number of one-bits in the two's complement binary
            count += (((1 << Integer.bitCount(i)) & 665772) > 0 ? 1 : 0);
        }
        return count;
    }
}


