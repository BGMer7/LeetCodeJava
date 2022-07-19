package com.gatsby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _2121IntervalsBetweenIdenticalElements
 * @Description: leetcode 2121 相同元素的间隔之和
 * @author: Gatsby
 * @date: 2022/7/18 16:55
 */

public class _2121IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            List<Integer> indexes = map.getOrDefault(arr[i], new ArrayList<>());
            indexes.add(i);
            map.put(arr[i], indexes);
        }
        // for (int i = 0; i < arr.length; ++i) {
            // List<Integer> indexes = map.get(arr[i]);
            // long s = 0;
            // // 如果每次都要这么计算的话，数据量大的时候会TLE
            // for (int index: indexes) {
            //     sum[i] += (long) Math.abs(i - index);
            // }
        // }
        long[] result = new long[arr.length];
        //遍历map的value
        for (List<Integer> list : map.values()) {
            //先计算出当前集合第一个元素所对应的间隔和,后续集合中的其它元素都可根据第一个间隔和推算出来
            for (int i : list) {
                result[list.get(0)] += i - list.get(0);
            }
            //遍历其它的相同元素,并根据第集合中第一个元素对应的间隔和推算出来
            for (int i = 1; i < list.size(); i++) {
                result[list.get(i)] = result[list.get(i - 1)] + (2L * i - list.size()) * (list.get(i) - list.get(i - 1));
            }
        }
        return result;
    }
}


