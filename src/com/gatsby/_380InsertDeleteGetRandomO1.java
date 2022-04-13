package com.gatsby;

import java.util.*;

/**
 * @ClassName: _380InsertDeleteGetRandomO1
 * @Description: leetcode 380 O(1) 时间插入、删除和获取随机元素
 * @author: Gatsby
 * @date: 2022/4/13 14:35
 */

public class _380InsertDeleteGetRandomO1 {
    List<Integer> nums;
    Random random;
    Map<Integer, Integer> num2index;

    public _380InsertDeleteGetRandomO1() {
        nums = new ArrayList<>();
        random = new Random();
        num2index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!num2index.containsKey(val)) {
            nums.add(val);
            num2index.put(val, nums.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (num2index.containsKey(val)) {
            int index = num2index.get(val);
            // 不能直接删，如果直接删除的话，那么就会所有的index都要往前移
            // 采取的策略是找一个num来和这个即将被移走的元素对调
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            nums.remove(nums.size() - 1); // 此时再把最后一个元素移除
            num2index.put(last, index); // 把这个改过位置的元素位置更新进map
            num2index.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }
}


