package com.gatsby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _599MinimumIndexSumOfTwoLists
 * @Description: leetcode 599 两个列表的最小索引总和
 * @author: Gatsby
 * @date: 2022/3/14 17:32
 */

public class _599MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map2 = new HashMap<>();

        int maxIndexSum = list1.length + list2.length;
        List<String> resList = new ArrayList<>();

        for (int i = 0; i < list2.length; ++i) {
            map2.put(list2[i], i);
        }

        for (int i = list1.length - 1; i >= 0; --i) {
            int index2 = map2.getOrDefault(list1[i], -1);
            if (index2 != -1) {
                if (index2 + i < maxIndexSum) {
                    resList.clear();
                    resList.add(list1[i]);
                    maxIndexSum = index2 + i;
                } else if (index2 + i == maxIndexSum) {
                    resList.add(list1[i]);
                }
            }
        }

        return resList.toArray(new String[0]);
    }
}


