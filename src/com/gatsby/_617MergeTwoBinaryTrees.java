package com.gatsby;


/**
 * @ClassName: _617MergeTwoBinaryTrees
 * @Description: leetcode 617 合并二叉树
 * @author: Gatsby
 * @date: 2022/5/12 11:27
 */

public class _617MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }
}


