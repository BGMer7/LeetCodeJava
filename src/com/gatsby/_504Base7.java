package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/3/7
 * @description -- leetcode 504 七进制数
 */


public class _504Base7 {
    public static String convertToBase7(int num) {
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = -num;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int digit = num % 7;
            stringBuilder.append(digit);
            num /= 7;
        }
        stringBuilder.reverse();
        if (!flag) return "-" + stringBuilder;
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String res = convertToBase7(100);
        System.out.println(res);
    }
}