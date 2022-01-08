package com.gatsby.contest.week274;

/**
 * @author -- gatsby
 * @date -- 2022/1/2
 * @description -- leetcode 5967 周赛274第一题，判断是否所有的a都在b之前
 * https://leetcode-cn.com/problems/check-if-all-as-appears-before-all-bs/
 * 5967. 检查是否所有 A 都在 B 之前
 * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
 * User Accepted:3205
 * User Tried:3235
 * Total Accepted:3253
 * Total Submissions:4581
 * Difficulty:Easy
 */


public class _5967CheckIfAllAAppearsBeforeB {
    public boolean checkString(String s) {
        boolean isEnd = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'b') isEnd = true;
            if (s.charAt(i) == 'a' && isEnd) return false;
        }
        return true;
    }
}