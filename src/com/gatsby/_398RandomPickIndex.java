package com.gatsby;

import java.util.*;

/**
 * @ClassName: _398RandomPickIndex
 * @Description: leetcode 398 随机数索引
 * @author: Gatsby
 * @date: 2022/4/25 19:58
 */

public class _398RandomPickIndex {
    Map<Integer, List<Integer>> positions;
    Random random;

    public _398RandomPickIndex(int[] nums) {
        positions = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> pos = positions.getOrDefault(nums[i], new ArrayList<>());
            pos.add(i);
            positions.put(nums[i], pos);
        }
    }

    public int pick(int target) {
        List<Integer> list = positions.get(target);
        return list.get(random.nextInt(list.size()));
    }



}


