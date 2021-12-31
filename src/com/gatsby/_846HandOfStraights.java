package com.gatsby;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _846HandOfStraights
 * @Description: leetcode 846 一手顺子
 * @author: Gatsby
 * @date: 2021/12/30 16:18
 */

public class _846HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        if (groupSize == 1) return true;

        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int card : hand) {
            if (cnt.containsKey(card)) {
                cnt.put(card, cnt.get(card) + 1);
            } else {
                cnt.put(card, 1);
            }
        }

        for (int card : hand) {
            if (cnt.get(card) != 0) {
                for (int i = 0; i < groupSize; ++i) {
                    int remain = cnt.getOrDefault(card+i, 0);
                    if (remain != 0) {
                        cnt.put(card + i, remain - 1);
                    } else return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _846HandOfStraights solution = new _846HandOfStraights();
        int[] hand = new int[]{8,10,12};
        int groupSize = 3;
        System.out.println(solution.isNStraightHand(hand, groupSize));
    }
}


