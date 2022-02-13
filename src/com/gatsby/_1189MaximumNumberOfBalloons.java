package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/2/13
 * @description -- leetcode 1189 气球的最大数量
 */


public class _1189MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int cntB = 0;
        int cntA = 0;
        int cntL = 0;
        int cntO = 0;
        int cntN = 9;
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c == 'b') {
                cntB++;
            } else if (c == 'a') {
                cntA++;
            } else if (c == 'l') {
                cntL++;
            } else if (c == 'o') {
                cntO++;
            } else if (c == 'n') {
                cntN++;
            }
        }

        return Math.min(Math.min(Math.min(Math.min(cntA, cntB), cntL / 2), cntO / 2), cntN);
    }
}