package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _144BinaryTreePreorderTraversal
 * @Description: leetcode 144 二叉树的前序遍历
 * @author: Gatsby
 * @date: 2022/5/14 11:27
 */

public class _144BinaryTreePreorderTraversal {
    private List<Integer> res;

    private void preorder(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        this.res = new ArrayList<>();
        preorder(root);
        return res;
    }
}


