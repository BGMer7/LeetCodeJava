package com.gatsby.contest.dweek69;

import java.util.*;

/**
 * @author -- gatsby
 * @date -- 2022/1/8
 * @description -- 双周赛 5962
 * 5962. 连接两字母单词得到的最长回文串 显示英文描述
 * User Accepted:549
 * User Tried:857
 * Total Accepted:553
 * Total Submissions:1374
 * Difficulty:Medium
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 * 示例 1：
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 * 提示：
 * 1 <= words.length <= 105
 * words[i].length == 2
 * words[i] 仅包含小写英文字母。
 */


/*
回文字符串加上两个相反的字符串才可以
未AC
 */
// https://leetcode-cn.com/problems/longest-palindrome-by-concatenating-two-letter-words/
public class _5962LongestPalindromeByConcatenatingTwoLetterWords {
    // 判断a和b是否相互对称
    private boolean isSymmetry(String a, String b) {
        return a.charAt(0) == b.charAt(1) && a.charAt(1) == b.charAt(0);
    }

    // 判断字符串本身是否回文
    private boolean isPalindrome(String s) {
        return s.charAt(0) == s.charAt(1);
    }

    public int longestPalindrome(String[] words) {
        // 统计每种字符串的个数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        for (String word : words) {
            // 求该字符串的反转字符串
            String reverse = new StringBuilder(word).reverse().toString();
            // 如果是两个字符相同的字符串，并且该类字符串剩余个数>=2，那么便可在回文串两侧分别添加一个该字符串
            if (reverse.equals(word) && map.get(word) >= 2) {
                map.put(word, map.get(word) - 2);
                ans += 2;
                // 如果是两个字符不同的字符串，并且该类字符串与其反转串剩余个数均>=1，那么便可在回文串两侧分别添加一个该字符串与其反转串
            } else if (!reverse.equals(word) && map.get(word) >= 1 && map.getOrDefault(reverse, 0) >= 1) {
                map.put(word, map.get(word) - 1);
                map.put(reverse, map.get(reverse) - 1);
                ans += 2;
            }
        }

        // 如果存在两个字符相同的字符串，可以添加到回文串的正中间（最多只能有一个）
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) >= 1) {
                return (ans + 1) * 2;
            }
        }
        return ans * 2;
    }
}