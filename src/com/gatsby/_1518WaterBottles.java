package com.gatsby;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @ClassName: _1518WaterBottles
 * @Description: leetcode1518 瓶装水兑换
 * @author: Gatsby
 * @date: 2021/12/17 12:32
 */

public class _1518WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            res += emptyBottles / numExchange;
            emptyBottles = (emptyBottles / numExchange) + (emptyBottles % numExchange);
        }
        return res;
    }

    public static void main(String[] args) {
        _1518WaterBottles solution = new _1518WaterBottles();
        System.out.println(solution.numWaterBottles(15, 4));
    }
}


