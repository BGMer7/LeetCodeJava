package com.gatsby;

import java.util.HashSet;

/**
 * @ClassName: _1346CheckIfDoubleExist
 * @Description: leetcode 1346 检查整数及其两倍数是否存在
 * @author: Gatsby
 * @date: 2022/5/13 23:38
 */

public class _1346CheckIfDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (set.contains(i)) return true;
            set.add(i * 2);
            if (i % 2 == 0) set.add(i / 2);
        }
        return false;
    }
}


