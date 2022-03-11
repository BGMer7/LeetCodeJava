package com.gatsby;

import java.util.List;

/**
 * @ClassName: Node
 * @Description: N叉树节点
 * @author: Gatsby
 * @date: 2022/3/11 14:32
 */

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};

