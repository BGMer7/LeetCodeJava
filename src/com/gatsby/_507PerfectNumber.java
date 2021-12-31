package com.gatsby;

/**
 * @ClassName: _507PerfectNumber
 * @Description: leetcode 507 完美数
 * @author: Gatsby
 * @date: 2021/12/31 9:48
 */

public class _507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int res = 0;

        for (int i = num - 1; i > 0; --i) {
            if (num % i == 0) res += i;
        }
        return num == res;
    }

    public boolean checkPerfectNumberList(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public static void main(String[] args) {
        _507PerfectNumber solution = new _507PerfectNumber();
        solution.checkPerfectNumber(808);
        solution.checkPerfectNumberList(8080);
    }
}


