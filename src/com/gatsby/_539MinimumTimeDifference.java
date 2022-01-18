package com.gatsby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _539MinimumTimeDifference
 * @Description: leetcode 539 最小时间差
 * @author: Gatsby
 * @date: 2022/1/18 10:07
 */

public class _539MinimumTimeDifference {
    public int calculateMinutes(String a, String b) {
        // a: 00:00
        // b: 23:59
        int hourA = Integer.parseInt(a.substring(0, 2));
        int hourB = Integer.parseInt(b.substring(0, 2));
        int minuteA = Integer.parseInt(a.substring(3, 5));
        int minuteB = Integer.parseInt(b.substring(3, 5));
        int diff1 = (hourB - hourA) * 60 + minuteB - minuteA;
        int diff2 = (hourA + 24 - hourB) * 60 + minuteA - minuteB;
        return Math.min(diff1, diff2);
    }

    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        for (int i = 1; i < timePoints.size(); ++i) {
            res = Math.min(calculateMinutes(timePoints.get(i-1), timePoints.get(i)), res);
        }
        // 首尾需要再比较一次
        res = Math.min(calculateMinutes(timePoints.get(0), timePoints.get(timePoints.size()-1)), res);
        return res;
    }

    public static void main(String[] args) {
        String a = "00:59";
        String b = "23:58";
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("04:00");
        timePoints.add("22:00");
        timePoints.add("00:01");
        _539MinimumTimeDifference solution = new _539MinimumTimeDifference();
        System.out.println(solution.findMinDifference(timePoints));
        System.out.println(solution.calculateMinutes(a, b));
    }
}


