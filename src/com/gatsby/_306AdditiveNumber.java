package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/10
 * @description -- leetcode 306 累加数
 */


public class _306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        // 太无聊了这题
        return false;
    }

    private static void changeString(String s) {
        s = "hello";
    }

    public static void main(String[] args) {
        String num = "112358";
        String sub = num.substring(1, 3);
        System.out.println(Integer.valueOf(sub));
        changeString(num);
        System.out.println(num);
    }
}