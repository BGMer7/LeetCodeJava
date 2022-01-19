package com.gatsby;

import java.util.*;

/**
 * @ClassName: _219ContainsDuplicateII
 * @Description: leetcode 219 存在重复元素2
 * @author: Gatsby
 * @date: 2022/1/19 10:46
 */

public class _219ContainsDuplicateII {
    // 由这道题思考到：ArrayList contains的时间复杂度 --- O(n)与底层实现原理
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _219ContainsDuplicateII solution = new _219ContainsDuplicateII();
        int[] a = {1, 2, 1};

        System.out.println(solution.containsNearbyDuplicate(a, 0));
    }
}


