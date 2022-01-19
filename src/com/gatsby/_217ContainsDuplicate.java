package com.gatsby;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _217ContainsDuplicate
 * @Description: leetcode 217 存在重复元素
 * @author: Gatsby
 * @date: 2022/1/19 11:20
 */

public class _217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }

    public boolean containsDuplicateSort(int[] nums) {
        if (nums.length <= 1) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}


