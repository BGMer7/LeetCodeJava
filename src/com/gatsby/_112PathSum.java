package com.gatsby;

/**
 * @ClassName: _112PathSum
 * @Description: leetcode 112 路径总和
 * @author: Gatsby
 * @date: 2022/5/16 18:03
 */

public class _112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}


