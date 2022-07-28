package com.gatsby;



/**
 * @ClassName: _1302DeepestLeavesSum
 * @Description:
 * @author: Gatsby
 * @date: 2022/7/21 13:35
 */

public class _1302DeepestLeavesSum {
    private int maxDepth = 0;
    private int sum;

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        ++depth;
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = root.val;
        } else if (depth == maxDepth) {
            sum += root.val;
        }
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}


