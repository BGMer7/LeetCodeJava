package com.gatsby;

import java.util.*;

/**
 * @author -- gatsby
 * @date -- 2022/7/9
 * @description -- 2171. 拿出最少数目的魔法豆
 */


public class _2171RemovingMinimumNumberOIfMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long res = Integer.MAX_VALUE;
        long sum = 0;
        // Set<Integer> beanSet = new HashSet<>();
        for (int bean : beans) {
            sum += bean;
            // beanSet.add(bean);
        }
        int n = beans.length;
        // for (int bean: beanSet) {
        //     res = Math.min(res, sum - ())
        // }
        for (int i = 0; i < n; ++i) {
            System.out.println(beans[i]);
            if (i != n - 1 && beans[i] == beans[i + 1]) continue;
            res = Math.min(res, sum - (long) beans[i] * (beans.length - i));
        }
        return res;
    }
}