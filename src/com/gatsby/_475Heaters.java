package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _475Heaters
 * @Description: leetcode 475 取暖器
 * @author: Gatsby
 * @date: 2021/12/20 18:07
 */

public class _475Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        final int heaterCnt = heaters.length;
        int radius = 0;
        int curHeater = 0;
        for (int house : houses) {
            while (curHeater < heaterCnt && heaters[curHeater] < house) {
                curHeater++;
            }

            if (curHeater == 0) {
                radius = Math.max(radius, heaters[curHeater] - house);
            } else if (curHeater == heaterCnt) {
                radius = Math.max(radius, house - heaters[curHeater - 1]);
            } else {
                radius = Math.max(radius, Math.min(heaters[curHeater] - house, house - heaters[curHeater - 1]));
            }
        }
        return radius;
    }

    public static void main(String[] args) {
        _475Heaters solution = new _475Heaters();
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        System.out.println(solution.findRadius(houses, heaters));
    }
}


