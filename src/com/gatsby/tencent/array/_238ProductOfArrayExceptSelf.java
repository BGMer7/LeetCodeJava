package com.gatsby.tencent.array;

/**
 * @author -- gatsby
 * @date -- 2022/3/5
 * @description -- leetcode 238 除自身以外的数组的乘积
 */


public class _238ProductOfArrayExceptSelf {
    /*
     * @author -- gatsby
     * @description -- 首先想到的办法是将这个数组所有数字的乘起来求积，
     * 然后每个数字遍历的时候使用这个总乘积除以本身，
     * 但是数组中如果出现了0就需要单独处理
     * @data -- 2022/3/5
     * @param -- [nums]
     * @return -- int[]
     */
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                product *= nums[i];
            }
        }

        if (zeroCount > 1) return new int[nums.length];
        int[] res = new int[nums.length];
        if (zeroCount == 0) {
            for (int i = 0; i < res.length; ++i) {
                res[i] = product / nums[i];
            }
        } else {
            for (int i = 0; i < res.length; ++i) {
                if (nums[i] == 0) {
                    res[i] = product;
                }
            }
        }
        return res;
    }

    /*
     * @author -- gatsby
     * @description -- 两次遍历，从左到右一次，计算左边的乘积，从右到左一次，计算右边的乘积
     * @data -- 2022/3/5
     * @param -- [nums]
     * @return -- int[]
     */
    public int[] productExceptSelf2dir(int[] nums) {
        int[] res = new int[nums.length];
        int productLeft = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = productLeft;
            productLeft *= nums[i];
        }
        int productRight = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= productRight;
            productRight *= nums[i];
        }
        return res;
    }
}