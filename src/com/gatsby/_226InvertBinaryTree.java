package com.gatsby;

/**
 * @ClassName: _226InvertBinaryTree
 * @Description: leetcode 226 翻转二叉树
 * @author: Gatsby
 * @date: 2022/5/16 17:53
 */

public class _226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }
}


