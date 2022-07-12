package com.gatsby;

/**
 * @ClassName: _700SearchInBinarySearchTree
 * @Description: leetcode 700 二叉搜索树中的搜索
 * @author: Gatsby
 * @date: 2022/5/17 14:13
 */

public class _700SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}


