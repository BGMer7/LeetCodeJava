package com.gatsby;

/**
 * @ClassName: _1672RichestCustomerWealth
 * @Description: leetcode 1672 最富有的客户的资产总量
 * @author: Gatsby
 * @date: 2022/4/14 14:32
 */

public class _1672RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int res = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int w = 0;
            for (int wealth : account) {
                w += wealth;
            }
            res = Math.max(w, res);
        }
        return res;
    }
}


