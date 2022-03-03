package com.gatsby.tencent.string;

/**
 * @author -- gatsby
 * @date -- 2022/3/3
 * @description -- leetcode 43 字符串相乘
 */


public class _43MultiplyStrings {
    public String multiply(String num1, String num2) {
        long n1 = 0, n2 = 0;
        for (int i = 0; i < num1.length(); ++i) {
            n1 = (n1 * 10 + num1.charAt(i) - '0');
        }
        for (int i = 0; i < num2.length(); ++i) {
            n2 = (n2 * 10 + num2.charAt(i) - '0');
        }
        System.out.println(n1);
        System.out.println(n2);
        long prod = n1 * n2;
        return String.valueOf(prod);
    }

    public String multiplyPlus(String n1, String n2) {
        int n = n1.length(), m = n2.length();
        int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = n1.charAt(i) - '0';
                int b = n2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];
                res[i + j + 1] = r % 10;
                res[i + j] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        _43MultiplyStrings solution = new _43MultiplyStrings();
        System.out.println(solution.multiply("1234234", "1234843"));
        System.out.println('1' - '0');
    }
}