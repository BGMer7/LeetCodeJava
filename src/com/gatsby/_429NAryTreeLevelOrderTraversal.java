package com.gatsby;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: _429NAryTreeLevelOrderTraversal
 * @Description: leetcode 429 N叉树的层序遍历
 * @author: Gatsby
 * @date: 2022/4/8 11:56
 */

public class _429NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node cur = deque.pollFirst();
                level.add(cur.val);
                for (Node child : cur.children) {
                    deque.add(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}


