package com.gatsby;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname _1640CheckArrayFormationThroughConcatenation
 * @description:
 * @author: gatsby
 * @create: 2022/9/22
 **/
public class _1640CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i])) return false;
            int[] array = map.get(arr[i]);
            for (int j = 0; j < array.length; ++j, ++i) {
                if (arr[i] != array[j]) return false;
            }
        }
        return true;
    }
}
