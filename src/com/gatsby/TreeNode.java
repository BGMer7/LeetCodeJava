package com.gatsby;

/**
 * @ClassName: TreeNode
 * @Description: 二叉搜索树BST binary search tree
 * @author: Gatsby
 * @date: 2022/3/22 23:31
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


