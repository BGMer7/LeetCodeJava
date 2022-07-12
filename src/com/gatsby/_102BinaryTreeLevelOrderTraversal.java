package com.gatsby;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _102BinaryTreeLevelOrderTraversal
 * @Description: leetcode 102 二叉树的层序遍历
 * @author: Gatsby
 * @date: 2022/5/15 19:07
 */

public class _102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelArray = new ArrayList<>();
            for (int i = 0; i < level; ++i) {
                TreeNode node = queue.poll();
                levelArray.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(levelArray);
        }
        return res;
    }
}


