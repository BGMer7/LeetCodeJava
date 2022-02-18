package com.gatsby;

/**
 * @ClassName: _1791FindCenterOfStarGraph
 * @Description: leetcode 1791 找出星型图的中心节点
 * @author: Gatsby
 * @date: 2022/2/18 13:52
 */

public class _1791FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        return (edges[1][0] == edges[0][0] || edges[1][1] == edges[0][0]) ? edges[0][0] : edges[0][1];
    }
}


