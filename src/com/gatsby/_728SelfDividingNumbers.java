package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _728SelfDividingNumbers
 * @Description: leetcode 728 自除数
 * @author: Gatsby
 * @date: 2022/3/31 10:33
 */

public class _728SelfDividingNumbers {
    private boolean isSelfDivided(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDivided(i)) {
                res.add(i);
            }
        }
        return res;
    }
}


