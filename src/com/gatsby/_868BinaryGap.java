package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/4/24
 * @description -- leetcode 868 二进制间距
 */


public class _868BinaryGap {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int lastOne = Integer.MAX_VALUE; // 确保i-lastOne可以作为一个负数，这样和0相比的话永远是0更大
        int max = 0;

        for (int i = 0; i < binaryString.length(); ++i) {
            if (binaryString.charAt(i) == '1') {
                max = Math.max(max, i - lastOne);
                lastOne = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 10;
        // Integer.toBinaryString将int转成二进制字符串
        System.out.println(Integer.toBinaryString(n));
    }
}