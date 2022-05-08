package com.gatsby;

/**
 * @ClassName: _367ValidPerfectSquare
 * @Description: leetcode 367 有效的完全平方数
 * @author: Gatsby
 * @date: 2022/5/7 17:15
 */

public class _367ValidPerfectSquare {
    /**
     * @MethodName: isPerfectSquare
     * @Parameter: [num]
     * @Return boolean
     * @Description: 牛顿迭代法
     * @author: Gatsby
     * @date: 2022/5/7 17:22
     */
    public boolean isPerfectSquareNewton(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left)/ 2;
            if (mid * mid > num) right = mid-1;
            else if (mid * mid < num) left = mid +1;
            else return true;
        }
        return false;
    }
}


