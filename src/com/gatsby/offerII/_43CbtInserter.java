package com.gatsby.offerII;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * @ClassName: _43CbtInserter
 * @Description: 剑指 Offer II 043. 往完全二叉树添加节点
 * @author: Gatsby
 * @date: 2022/7/29 9:45
 */

public class _43CbtInserter {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;
    private Queue<TreeNode> candidate;

    public _43CbtInserter(TreeNode root) {
        this.root = root;
        this.candidate = new ArrayDeque<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!Objects.isNull(node.left)) {
                queue.add(node.left);
            }
            if (!Objects.isNull(node.right)) {
                queue.add(node.right);
            }
            if (!Objects.isNull(node.left) || !Objects.isNull(node.right)) {
                candidate.add(node);
            }
        }
    }

    public int insert(int v) {
        TreeNode child = new TreeNode(v);
        TreeNode node = candidate.peek();
        if (Objects.isNull(node.left)) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.add(child);
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}


