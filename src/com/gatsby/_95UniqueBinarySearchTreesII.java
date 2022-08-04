package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _95UniqueBinarySearchTreesII
 * @Description:
 * @author: Gatsby
 * @date: 2022/8/4 9:51
 */

public class _95UniqueBinarySearchTreesII {


    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();
        else return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }

        }
        return res;
    }
}


