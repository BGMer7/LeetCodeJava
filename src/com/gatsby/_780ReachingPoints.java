package com.gatsby;

/**
 * @ClassName: _780ReachingPoints
 * @Description: leetcode 780 到达终点
 * @author: Gatsby
 * @date: 2022/4/9 14:35
 */

/*
3 5
3 2
1 2
1 1
 */

public class _780ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) {
                // tx -= ty;因为有可能是不断加上来的，所以求余的话就一步到位
                tx %= ty;
            } else if (tx < ty) {
                // ty -= tx;
                ty %= tx;
            } else {
                break;
            }
        }

        if (tx < sx || ty < sy) return false;
        return sx == tx ? (ty - sy) % tx == 0 : (tx - sx) % ty == 0;
    }
}


