package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/2
 * @description -- leetcode 390 消除游戏
 */


public class _390EliminationGame {
    public int lastRemaining(int n) {
        int first = 1;
        int step = 1;
        int remain = n;
        boolean isLeft = true;
        while (remain > 1) {
            if (isLeft || ((remain & 1) == 1)) {
                first += step;
            }
            isLeft = !isLeft;
            step <<= 1;
            remain >>= 1;
        }
        return first;
    }

    public static void main(String[] args) {
        _390EliminationGame solution = new _390EliminationGame();
        System.out.println(solution.lastRemaining(10000));
    }
}