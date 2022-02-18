package com.gatsby;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * @author -- gatsby
 * @date -- 2022/2/13
 * @description -- leetcode 1405 最长快乐字符串
 */


public class _1405LongestHappyString {
    /*
     * @author -- gatsby
     * @description -- 说白了是一种贪心算法，每次都取合法的字符当中的现存最多的字符
     * @data -- 2022/2/13
     * @param -- [a, b, c]
     * @return -- java.lang.String
     */
    public String longestDiverseString(int a, int b, int c) {
        // 创建一个大根堆
        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        if (a > 0) queue.offer(new Pair<>('a', a));
        if (b > 0) queue.offer(new Pair<>('b', b));
        if (c > 0) queue.offer(new Pair<>('c', c));

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair<Character, Integer> head = queue.poll();
            // 如果前两个字母都是当前的字母的话，属于不合法的情况
            int n = res.length();
            System.out.println(head.getKey() == 'c');
            if (n >= 2 && res.charAt(n - 1) == head.getKey() && res.charAt(n - 2) == head.getKey()) {
                // 除了非法选择之外已经没有别的选择了，此时的res已经是最长的快乐字符串了
                if (queue.isEmpty()) break;

                // 此时的操作已经和head没有关系，将head重新塞回去
                Pair<Character, Integer> alternative = queue.poll();
                // 此时的操作已经和head没有关系，将head重新塞回去
                queue.offer(head);
                res.append(alternative.getKey());
                // 如果数量还大于0就塞回去，不大于零的话就没必要塞回去了
                if (alternative.getValue() - 1 > 0) {
                    queue.offer(new Pair<>(alternative.getKey(), alternative.getValue() - 1));
                }
            } else {
                res.append(head.getKey());
                if (head.getValue() - 1 > 0) {
                    queue.offer(new Pair<>(head.getKey(), head.getValue() - 1));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _1405LongestHappyString solution = new _1405LongestHappyString();
        solution.longestDiverseString(1, 1, 7);
        Pair<Character, Integer> pair = new Pair<>('c', 10);
    }
}