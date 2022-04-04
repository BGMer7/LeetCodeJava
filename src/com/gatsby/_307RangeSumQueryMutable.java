package com.gatsby;

/**
 * @ClassName: _307RangeSumQueryMutable
 * @Description: leetcode 307 区域和检索 - 数组可修改
 * @author: Gatsby
 * @date: 2022/4/4 9:13
 */

public class _307RangeSumQueryMutable {
    private int n;
    private int[] nums;

    // tree array树状数组
    int[] tr;

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tr[i] += u;
        }
    }

    private int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

    public _307RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        tr = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            // why add i+1
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        _307RangeSumQueryMutable solution = new _307RangeSumQueryMutable(nums);
        System.out.println(solution.lowbit(8));
    }
}


