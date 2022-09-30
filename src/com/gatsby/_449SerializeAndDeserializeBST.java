package com.gatsby;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @classname _449SerializeAndDeserializeBST
 * @description:
 * @author: bgm
 * @create: 2022/9/30
 **/

class Codec {
    private TreeNode root;

    public String serialize(TreeNode root) {
        this.root = root;
        return "";
    }

    public TreeNode root(String data) {
        return root;
    }
}

public class _449SerializeAndDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            stringBuilder.append("#");
            if (node != null) {
                queue.add(root.left);
                queue.add(root.right);
                stringBuilder.append(node.val);
            }
        }
        return stringBuilder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        String s[] = data.split("#", -1);
        TreeNode ans = new TreeNode(Integer.parseInt(s[1]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ans);
        for (int i = 3; i < s.length; i += 2) {
            TreeNode t = q.poll();
            if (s[i - 1].length() > 0) {
                t.left = new TreeNode(Integer.parseInt(s[i - 1]));
                q.add(t.left);
            }
            if (s[i].length() > 0) {
                t.right = new TreeNode(Integer.parseInt(s[i]));
                q.add(t.right);
            }
        }
        return ans;
    }
}
