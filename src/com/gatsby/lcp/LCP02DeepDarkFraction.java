package com.gatsby.lcp;

/**
 * @ClassName: LCP02DeepDarkFraction
 * @Description: LCP 02. Deep Dark Fraction分式化简
 * @author: Gatsby
 * @date: 2022/1/12 19:33
 */

public class LCP02DeepDarkFraction {
    public int[] fraction(int[] cont) {
        // 分子
        int numerator = 1;
        // 分母
        int denominator = cont[cont.length - 1];

        for (int i = cont.length - 2; i >= 0; --i) {
            int tmp = denominator;
            denominator = cont[i] * denominator + numerator;
            numerator = tmp;
        }
        return new int[]{denominator, numerator};
    }
}


