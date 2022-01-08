package com.gatsby;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author -- gatsby
 * @date -- 2022/1/6
 * @description -- leetcode 71 简化路径
 */


public class _71SimplifyPath {
    public String simplifyPath(String path) {
        if(!path.contains(".")) {
            path = "/" + path + "/";
            path = path.replace(".", "");
            path = path.replace("..", "");
            path = path.replace("//", "/");
            return path.substring(0, path.length() - 1);
        }else
        {
            Deque<String> dq = new ArrayDeque<>();

        }
        return "";

    }

    public static void main(String[] args) {
        _71SimplifyPath solution = new _71SimplifyPath();
        System.out.println(solution.simplifyPath("/home//..foo/"));
    }
}