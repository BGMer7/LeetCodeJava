package com.gatsby;

/**
 * @ClassName: _34FindFirstAndLastPositionInSortedArray
 * @Description: leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 * @author: Gatsby
 * @date: 2022/4/6 16:51
 */

public class _34FindFirstAndLastPositionInSortedArray {
    /**
     * @MethodName: searchRange
     * @Parameter: [nums, target]
     * @Return int[]
     * @Description: 找到任意一个target之后，向前和向后寻找，直到不一样
     *
     * 二分用这个模板就不会出错了。满足条件的都写l = mid或者r = mid，
     * mid首先写成l + r >> 1，如果满足条件选择的是l = mid，那么mid那里就加个1，写成l + r + 1 >> 1。
     * 然后就是else对应的写法，l = mid对应r = mid - 1，r = mid对应l = mid + 1。跟着y总学的，嘿嘿。
     * @author: Gatsby
     * @date: 2022/4/6 20:31
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) return new int[]{-1, -1};
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int first = left;
        int last = left;
        while (first - 1 >= 0 && nums[first - 1] == nums[left]) {
            first--;
        }
        while (last + 1 < nums.length && nums[last + 1] == nums[left]) {
            last++;
        }
        return new int[]{first, last};
    }

    public int[] searchRangeBS(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length==0) return res;

        int l = 0, r = nums.length - 1;
        // 查找到target之后，给res[0]赋值，继续向左二分查找
        while(r>=l){
            int mid = (l + r) / 2;
            if(nums[mid]==target){
                res[0] = mid;
                r = mid - 1;
            }
            else if(nums[mid]>target) r = mid - 1;
            else if(nums[mid]<target) l = mid + 1;
        }
        // 别忘了重置
        l = 0;
        r = nums.length - 1;
        // 查找到target之后，给res[1]赋值，继续向右左二分查找
        while(r>=l){
            int mid = (l + r) / 2;
            if(nums[mid]==target){
                res[1] = mid;
                l = mid + 1;
            }
            else if(nums[mid]>target) r = mid - 1;
            else if(nums[mid]<target) l = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        _34FindFirstAndLastPositionInSortedArray solution = new _34FindFirstAndLastPositionInSortedArray();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.searchRange(nums, 2));
    }
}


