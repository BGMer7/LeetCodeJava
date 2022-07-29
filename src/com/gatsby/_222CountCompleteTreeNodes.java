package com.gatsby;

import java.util.Objects;

/**
 * @ClassName: _222CountCompleteTreeNodes
 * @Description: leetcode 222 完全二叉树的节点数量
 * @author: Gatsby
 * @date: 2022/7/29 10:48
 */

public class _222CountCompleteTreeNodes {
    /**
     * @MethodName: countNodes
     * @Parameter: [root]
     * @Return int
     * @Description: 递归
     * @author: Gatsby
     * @date: 2022/7/29 10:50
     */
    public int countNodes(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        } else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * @MethodName: countNodesBs
     * @Parameter: [root]
     * @Return int
     * @Description: 二分查找
     * @author: Gatsby
     * @date: 2022/7/29 10:58
     */
    public int countNodesBs(TreeNode root) {
        if (Objects.isNull(root)) return 0;
        int left = countHeight(root.left);
        int right = countHeight(root.right);

        // 如果左子树和右子树的深度相等，那么左子树一定是个满二叉树，加上一个root节点
        // 直接用1 << left计算就行
        if (left == right) {
            return countNodesBs(root.right) + (1 << left);
        }
        return countNodesBs(root.left) + (1 << right);
    }

    private int countHeight(TreeNode root) {
        int height = 0;
        while (!Objects.isNull(root)) {
            height++;
            root = root.left;
        }
        return height;
    }
}


