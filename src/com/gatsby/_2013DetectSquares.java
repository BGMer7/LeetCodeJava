package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _2013DetectSquares
 * @Description: leetcode 2013 检测正方形
 * @author: Gatsby
 * @date: 2022/1/26 10:27
 */

public class _2013DetectSquares {
    Map<Integer, Map<Integer, Integer>> xMap;
    Map<Integer, Map<Integer, Integer>> yMap;

    public _2013DetectSquares() {
        this.xMap = new HashMap<>();
        this.yMap = new HashMap<>();
    }

    /**
     * @MethodName:  add
     * @Parameter: [point]
     * @Return void
     * @Description: 传参是一个点的横纵坐标
     * @author: Gatsby
     * @date:  2022/1/26 18:20
     */
    public void add(int[] point) {
        // xMap存储[x坐标, [y坐标，这个y坐标线上有多少点]]
        Map<Integer, Integer> x = xMap.getOrDefault(point[0], new HashMap<>());
        x.put(point[1], x.getOrDefault(point[1], 0) + 1);
        xMap.put(point[0], x);
        // yMap存储[y坐标, [x坐标，这个x坐标线上有多少点]]
        Map<Integer, Integer> y = yMap.getOrDefault(point[1], new HashMap<>());
        y.put(point[0], y.getOrDefault(point[0], 0) + 1);
        yMap.put(point[1], y);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int res = 0;
        // find a point b(x + ?, y)
        if (!yMap.containsKey(y)) return 0;
        // sameY = [x坐标, 这个x坐标上的点的个数]
        Map<Integer, Integer> sameY = yMap.get(y);
        // iterating all b points
        for (int bX : sameY.keySet()) {
            int bCount = sameY.get(bX);
            // 边长
            int d = bX - x;
            if (d != 0) {
                // find c
                if (!xMap.containsKey(x)) continue;
                Map<Integer, Integer> sameX = xMap.get(x);
                if (sameX.containsKey(y - d)) {
                    // find d
                    if (xMap.get(bX) != null && xMap.get(bX).containsKey(y - d)) {
                        int cCount = sameX.get(y - d);
                        int dCount = xMap.get(bX).get(y - d);
                        res += cCount * dCount * bCount;
                    }
                }
                if (sameX.containsKey(y + d)) {
                    // find d
                    if (xMap.get(bX) != null && xMap.get(bX).containsKey(y + d)) {
                        int cCount = sameX.get(y + d);
                        int dCount = xMap.get(bX).get(y + d);
                        res += cCount * dCount * bCount;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _2013DetectSquares solution = new _2013DetectSquares();
        solution.add(new int[]{3, 10});
        solution.add(new int[]{11, 2});
        solution.add(new int[]{3, 2});
        solution.count(new int[]{11, 10});
        solution.count(new int[]{14, 8});
        solution.add(new int[]{11, 2});
        solution.count(new int[]{11, 10});
    }
}


