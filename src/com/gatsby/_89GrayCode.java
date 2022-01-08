package com.gatsby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/1/8
 * @description -- leetcode 89 格雷编码
 */


public class _89GrayCode {
    public List<Integer> greyCode(int n) {
        int size = 1 << n;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            res.add(i^(i>>1));
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        _89GrayCode solution = new _89GrayCode();
        solution.greyCode(2);
    }
}