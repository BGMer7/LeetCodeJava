package com.gatsby;

/**
 * @ClassName: _101SymmetricTree
 * @Description: leetcode 101 对称二叉树
 * @author: Gatsby
 * @date: 2022/5/15 20:03
 */

public class _101SymmetricTree {
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null || right != null) return false;
        if (left.val != right.val) return false;

        return isSymmetric(left.right, right.left) && isSymmetric(right.left, left.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }
}


