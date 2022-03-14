package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _590NaryTreePostorderTraversal
 * @Description: leetcode 590 N叉树的后序遍历
 * @author: Gatsby
 * @date: 2022/3/14 18:00
 */

public class _590NaryTreePostorderTraversal {
    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
}


