package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _589NaryTreePreorderTraversal
 * @Description: leetcode 589 N叉树的前序遍历
 * @author: Gatsby
 * @date: 2022/3/11 14:35
 */

public class _589NaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }

    public List<Integer> preorder(Node root) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return res;
    }
}


