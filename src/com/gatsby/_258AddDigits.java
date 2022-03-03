package com.gatsby;

/**
 * @ClassName: _258AddDigits
 * @Description: leetcode 258 各位相加
 * @author: Gatsby
 * @date: 2022/3/3 14:35
 */

public class _258AddDigits {
    private int digitsSum(int n) {
        if (n / 10 == 0) return n;
        int sum = 0;
        while (n / 10 != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum + n;
    }

    public int addDigits(int num) {
        if (num < 10) return num;
        while (num / 10 != 0) {
            num = digitsSum(num);
        }
        return num;
    }

    public int addDigitsMath(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        _258AddDigits solution = new _258AddDigits();
        System.out.println(solution.addDigitsMath(34204234));
    }
}


