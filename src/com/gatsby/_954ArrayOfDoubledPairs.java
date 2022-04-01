package com.gatsby;

import java.util.*;

/**
 * @ClassName: _954ArrayOfDoubledPairs
 * @Description: leetcode  954 二倍数对数组
 * @author: Gatsby
 * @date: 2022/4/1 14:52
 */

public class _954ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>(cnt.keySet());
        Collections.sort(vals, (a, b)->Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}


