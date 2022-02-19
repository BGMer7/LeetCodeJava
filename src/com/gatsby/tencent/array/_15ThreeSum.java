package com.gatsby.tencent.array;

import java.util.*;

/**
 * @author -- gatsby
 * @date -- 2022/2/19
 * @description -- leetcode 15 三数之和
 */


public class _15ThreeSum {
    /*
     * @author -- gatsby
     * @description -- 最简单的暴力解法，但是即使是暴力解法也有几个地方需要注意
     * 1. 结果需要去重，想到去重那就是想到Set去重
     * 2. 其次是必须排序，因为这道题最终的结果中，不允许出现相同结果
     * 对于相同结果的定义是，只要元素一样，就算相同，不管顺序，也就是说[1,0,-1][0,-1,1]这两个是重复的
     * 所以如果不排序的话，即使是Set也没有办法去重
     * 3. 但是尽管如此，在测试用例中暴力解法还是超时的
     * @data -- 2022/2/19
     * @param -- [nums]
     * @return -- java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) return res;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>(res);
        res.clear();
        res.addAll(set);
        return res;
    }

    private List<List<Integer>> sortedRes;
    private int[] nums;

    /*
     * @author -- gatsby 
     * @description -- 把最外面那层剥离，那么其实剩下的其实就是一个TwoSum的问题
     * 只是这一次由于不是index，所以存在去重的问题
     * 去重的关键是：如果遇到后面的数值和当前一样，那就往后移
     * 但是要注意的一点是要保证left始终小于right
     * @data -- 2022/2/19
     * @param -- [firstNum, left, right] 
     * @return -- void
    */
    private void calculate(int firstNum, int left, int right) {
        while (left < right) {
            int sum = firstNum + nums[left] + nums[right];
            if (sum == 0) {
                sortedRes.add(Arrays.asList(firstNum, nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    /*
     * @author -- gatsby 
     * @description -- 只需要遍历最外层，剩下的工作交给Calculate方法做了
     * @data -- 2022/2/19
     * @param -- [nums] 
     * @return -- java.util.List<java.util.List<java.lang.Integer>>
    */
    public List<List<Integer>> threeSumTwoPtrs(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        sortedRes = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            calculate(nums[i], i + 1, n - 1);
        }
        return sortedRes;
    }
}