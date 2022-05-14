package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _94BinaryTreeInorderTraversal
 * @Description: leetcode 94 二叉树的中序遍历
 * @author: Gatsby
 * @date: 2022/5/14 11:43
 */

public class _94BinaryTreeInorderTraversal {
    private List<Integer> res;

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        this.res = new ArrayList<>();
        inorder(root);
        return res;
    }
}


