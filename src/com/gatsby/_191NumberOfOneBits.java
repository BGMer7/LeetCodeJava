package com.gatsby;

/**
 * @ClassName: _191NumberOfOneBits
 * @Description: leetcode 191 位1的数量
 * @author: Gatsby
 * @date: 2022/5/17 11:49
 */

public class _191NumberOfOneBits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}


