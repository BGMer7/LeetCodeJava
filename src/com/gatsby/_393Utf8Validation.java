package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/3/14
 * @description -- leetcode 393 Utf-8编码验证
 * 此题代码并不符合题意，因为实际上题目中给出的数据并不是只有一个utf8的字符
 */


public class _393Utf8Validation {
    public static String binaryConvert(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int a = 128;
        while (i != 0) {
            stringBuilder.append(i / a);
            i %= a;
            a /= 2;
        }
        return stringBuilder.toString();
    }

    public boolean validUtf8(int[] data) {
        int n = data.length;
        if (n == 1) {
            String s = binaryConvert(data[0]);
            return s.charAt(0) == '0';
        }

        String firstByte = binaryConvert(data[0]);
        for (int i = 0; i < n; ++i) {
            if (firstByte.charAt(i) == '0') {
                return false;
            }
        }

        for (int i = 1; i < n; ++i) {
            String binary = binaryConvert(data[i]);
            if (!binary.startsWith("01")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(binaryConvert(197));
    }
}