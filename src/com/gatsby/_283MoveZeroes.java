package com.gatsby;

/**
 * @ClassName: _283MoveZeroes
 * @Description: leetcode 283 移动零
 * @author: Gatsby
 * @date: 2022/3/21 21:47
 */

public class _283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int ptr = 0;
        while (zero < n) {
            if (nums[zero] != 0) {
                nums[ptr++] = nums[zero];
            }
            zero++;
        }

        for (int i = ptr; i < n; ++i) {
            nums[i] = 0;
        }
    }
}


