package com.gatsby.contest.week274;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author -- gatsby
 * @date -- 2022/1/2
 * @description -- leetcode 5969 摧毁小行星
 * https://leetcode-cn.com/problems/destroying-asteroids/
 * 5969. 摧毁小行星
 * 给你一个整数 mass ，它表示一颗行星的初始质量。再给你一个整数数组 asteroids ，其中 asteroids[i] 是第 i 颗小行星的质量。
 * <p>
 * 你可以按 任意顺序 重新安排小行星的顺序，然后让行星跟它们发生碰撞。如果行星碰撞时的质量 大于等于 小行星的质量，那么小行星被 摧毁 ，并且行星会 获得 这颗小行星的质量。否则，行星将被摧毁。
 * <p>
 * 如果所有小行星 都 能被摧毁，请返回 true ，否则返回 false 。
 * User Accepted:2878
 * User Tried:3070
 * Total Accepted:2919
 * Total Submissions:6483
 * Difficulty:Medium
 */


public class _5969DestroyingAsteroids {
    private int findMaxBelow(int n, List<Integer> asteroids) {
        if (asteroids.size() == 0) return 0;
        for (int asteroid : asteroids) {
            if (asteroid <= n) return asteroid;
        }
        return -1;

    }

    /**
     * 方法过于追求取巧，会在数量很大时产生错误, AC: 64/66
     *
     * @param mass
     * @param asteroids
     * @return
     */
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        List<Integer> astList = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
        Collections.sort(astList);
        Collections.reverse(astList);
        int maxAsteroid = astList.get(0);
        while (findMaxBelow(mass, astList) > 0) {
            int next = findMaxBelow(mass, astList);
            mass += next;
            if (mass >= maxAsteroid) return true;
            for (int i = 0; i < astList.size(); ++i) {
                if (astList.get(i) == next)
                    astList.remove(i);
            }
        }
        return astList.size() == 0;
    }

    public boolean destroy(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int max = asteroids[asteroids.length - 1];
        for (int asteroid : asteroids) {
            if (mass < asteroid) return false;
            else if (mass > max) return true;
            else mass += asteroid;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] asteroids = new int[]{4, 9, 23, 4};
        _5969DestroyingAsteroids solution = new _5969DestroyingAsteroids();
        System.out.println(solution.asteroidsDestroyed(5, asteroids));
    }
}