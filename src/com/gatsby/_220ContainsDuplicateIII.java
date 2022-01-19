package com.gatsby;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _220ContainsDuplicateIII
 * @Description: leetcode 220 包含重复元素III
 * @author: Gatsby
 * @date: 2022/1/19 12:34
 */

public class _220ContainsDuplicateIII {
    long size;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && Math.abs(u - map.get(l)) <= t) return true;
            if (map.containsKey(r) && Math.abs(u - map.get(r)) <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k]));
        }
        return false;
    }

    private long getIdx(long u) {
        return u >= 0 ? u / size : (u + 1) / size - 1;
    }

    public static void main(String[] args) {
        _220ContainsDuplicateIII solution = new _220ContainsDuplicateIII();
        int[] a = {1, 5, 9, 1, 5, 9};

        System.out.println(solution.containsNearbyAlmostDuplicate(a, 3, 3));
    }
}


