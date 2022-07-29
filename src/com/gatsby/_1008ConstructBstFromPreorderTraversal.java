package com.gatsby;

import java.util.Objects;

/**
 * @ClassName: _1008ConstructBstFromPreorderTraversal
 * @Description: 1008. 前序遍历构造二叉搜索树
 * @author: Gatsby
 * @date: 2022/7/29 11:21
 */

public class _1008ConstructBstFromPreorderTraversal {

    private void insert(int val, TreeNode node) {
        if (val < node.val) {
            if (Objects.isNull(node.left)) {
                node.left = new TreeNode(val);
            } else {
                insert(val, node.left);
            }
        } else {
            if (Objects.isNull(node.right)) {
                node.right = new TreeNode(val);
            } else {
                insert(val, node.right);
            }
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < len; ++i) {
            insert(preorder[i], root);
        }
        return root;
    }

    // TODO 区间划分找分割点
}


