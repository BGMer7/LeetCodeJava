package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _145BinaryTreePostorderTraversal
 * @Description: leetcode 145 二叉树的后序遍历
 * @author: Gatsby
 * @date: 2022/5/14 11:45
 */

public class _145BinaryTreePostorderTraversal {
    private List<Integer> res;

    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        this.res = new ArrayList<>();
        postorder(root);
        return res;
    }
}


