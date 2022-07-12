package com.gatsby;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _104MaximumDepthOfBinaryTree
 * @Description: leetcode 104 二叉树的最大深度
 * @author: Gatsby
 * @date: 2022/5/15 19:26
 */

public class _104MaximumDepthOfBinaryTree {
    /**
     * @MethodName: maxDepth
     * @Parameter: [root]
     * @Return int
     * @Description: 递归
     * @author: Gatsby
     * @date: 2022/5/15 19:27
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthlevel(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelArray = new ArrayList<>();
            for (int i = 0; i < level; ++i) {
                TreeNode node = queue.poll();
                levelArray.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}


