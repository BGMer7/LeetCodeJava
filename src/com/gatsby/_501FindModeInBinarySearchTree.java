package com.gatsby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _501FindModeInBinarySearchTree
 * @Description: leetcode 501 二叉搜索树中的众数
 * @author: Gatsby
 * @date: 2022/3/22 23:30
 */

public class _501FindModeInBinarySearchTree {
    private Map<Integer, Integer> cnt = new HashMap<>();

    /**
     * @MethodName: inOrder
     * @Parameter: [root]
     * @Return void
     * @Description: 中序遍历
     * @author: Gatsby
     * @date: 2022/3/22 23:46
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        cnt.put(root.val, cnt.getOrDefault(root.val, 0) + 1);
        inOrder(root.right);
    }

    /**
     * @MethodName:  findMode
     * @Parameter: [root]
     * @Return int[]
     * @Description: 中序遍历，将出现的次数储存在一个map中，找出众数
     * @author: Gatsby
     * @date:  2022/3/23 0:05
     */
    public int[] findMode(TreeNode root) {
        inOrder(root);
        List<Integer> res = new ArrayList<>();
        int mode = Integer.MIN_VALUE;
        for (int num : cnt.keySet()) {
            int count = cnt.get(num);
            if (count > mode) {
                res.clear();
                res.add(num);
                mode = count;
            }
            else if (count == mode) {
                res.add(num);
            }
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < a.length; i ++) {
            a[i] = res.get(i);
        }
        return a;
    }
}


