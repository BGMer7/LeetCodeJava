package com.gatsby.contest.week274;

/**
 * @author -- gatsby
 * @date -- 2022/1/2
 * @description -- leetcode 5968 周赛274 第2题 银行中的激光数量
 * https://leetcode-cn.com/problems/number-of-laser-beams-in-a-bank/
 * 5968. 银行中的激光束数量
 * 银行内部的防盗安全装置已经激活。给你一个下标从 0 开始的二进制字符串数组 bank ，表示银行的平面图，这是一个大小为 m x n 的二维矩阵。 bank[i] 表示第 i 行的设备分布，由若干 '0' 和若干 '1' 组成。'0' 表示单元格是空的，而 '1' 表示单元格有一个安全设备。
 *
 * 对任意两个安全设备而言，如果同时 满足下面两个条件，则二者之间存在 一个 激光束：
 *
 * 两个设备位于两个 不同行 ：r1 和 r2 ，其中 r1 < r2 。
 * 满足 r1 < i < r2 的 所有 行 i ，都 没有安全设备 。
 * 激光束是独立的，也就是说，一个激光束既不会干扰另一个激光束，也不会与另一个激光束合并成一束。
 *
 * 返回银行中激光束的总数量。
 *
 * User Accepted:3036
 * User Tried:3063
 * Total Accepted:3066
 * Total Submissions:3638
 * Difficulty:Medium
 */


public class _5968NumberOfLaserBeamsInBank {
    private int cnt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') res++;
        }
        return res;
    }

    public int numberOfBeams(String[] bank) {
        if (bank.length == 1) return 0;
        int row = bank.length;
        int ahead = -1;
        int res = 0;
        int[] equipmentsCnt = new int[row];
        for (int i = 0; i < row; ++i) {
            equipmentsCnt[i] = cnt(bank[i]);
            if (ahead == -1 && equipmentsCnt[i] != 0)
                ahead = i;
        }

        if (ahead == -1 || ahead == row - 1) return 0;
        int rear = ahead + 1;

        while (rear <= row - 1) {
            if (equipmentsCnt[rear] != 0) {
                res += equipmentsCnt[ahead] * equipmentsCnt[rear];
                ahead = rear;
                rear++;
            } else rear++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};

        _5968NumberOfLaserBeamsInBank solution = new _5968NumberOfLaserBeamsInBank();
        System.out.println(solution.numberOfBeams(bank));
    }
}

