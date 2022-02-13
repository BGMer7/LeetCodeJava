package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/2/13
 * @description -- leetcode 1447 最简分数
 */


public class _1447SimplifiedFractions {
    /*
     * @author -- gatsby
     * @description -- 求两个数的最大公约数
     * @data -- 2022/2/13
     * @param -- [a, b]
     * @return -- int
     */
    public int gcd(int a, int b) {
        if (b % a == 0) {
            return a;
        }
        return gcd(b % a, a);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();

        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    res.add(numerator + "/" + denominator);
                }
            }
        }
        return res;
    }
}