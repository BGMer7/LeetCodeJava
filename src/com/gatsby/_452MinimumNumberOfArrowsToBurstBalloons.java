package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _452MinimumNumberOfArrowsToBurstBalloons
 * @Description: 452. 用最少数量的箭引爆气球
 * @author: Gatsby
 * @date: 2022/7/25 14:10
 */

public class _452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] point1, int[] point2) -> {
            // case [[-2147483646,-2147483645],[2147483646,2147483647]]
            // 如果使用a-b的话会导致溢出
            return Integer.compare(point1[1], point2[1]);
        });
        int res = 1; // 至少要有一只箭
        int maxCover = points[0][1]; // 以最右端为箭的最远端，判断下一个气球的最左边能不能被cover

        for (int[] point : points) {
            if (point[0] <= maxCover) {
                continue;
            } else {
                res++;
                maxCover = point[1];
            }
        }
        return res;
    }
}


