package com.gatsby;

/**
 * @ClassName: _796RotateString
 * @Description: leetcode 796 旋转字符串
 * @author: Gatsby
 * @date: 2022/4/7 9:22
 */

public class _796RotateString {
    /**
     * @MethodName:  rotateString
     * @Parameter: [s, goal]
     * @Return boolean
     * @Description: s+s之后，就从头到尾有两遍，那么如果goal是由s旋转来的，就一定是s+s的子串
     * @author: Gatsby
     * @date:  2022/4/7 9:40
     */
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && new StringBuilder(s).append(s).toString().contains(goal);
    }
}


