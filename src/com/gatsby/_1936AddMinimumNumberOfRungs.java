package com.gatsby;

/**
 * @ClassName: _1936AddMinimumNumberOfRungs
 * @Description: 1936. Add Minimum Number of Rungs
 * @author: Gatsby
 * @date: 2022/7/29 11:44
 */

public class _1936AddMinimumNumberOfRungs {

    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < rungs.length; ++i) {
            int dis = rungs[i] - cur;
            if (dis > dist) res += (dis - 1) / dist;
            cur = rungs[i];
        }
        return res;
    }
}


