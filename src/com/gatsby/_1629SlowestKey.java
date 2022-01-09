package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/9
 * @description -- leetcode 1629 按键持续时间最长的键
 */


public class _1629SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        final int n = releaseTimes.length;
        if (n == 0) return ' ';
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > ans)) {
                ans = key;
                maxTime = time;
            }
        }
        return ans;
    }
}