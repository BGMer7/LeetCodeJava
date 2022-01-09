package com.gatsby;

import java.util.HashSet;
import java.util.Set;

/**
 * @author -- gatsby
 * @date -- 2022/1/9
 * @description -- leetcode 771
 */


public class _771JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); ++i) {
            jewelSet.add(jewels.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < stones.length(); ++i) {
            if (jewelSet.contains(stones.charAt(i))) res++;
        }
        return res;
    }
}