package com.gatsby;

/**
 * @ClassName: _701InsertIntoBinarySearchTree
 * @Description: leetcode 701 二叉搜索树中的插入操作
 * @author: Gatsby
 * @date: 2022/5/17 15:02
 */

public class _701InsertIntoBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
            return root;
        } else {
            root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}


