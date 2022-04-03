package com.gatsby;

/**
 * @ClassName: _744FindSmallestLetterGreaterThanTarget
 * @Description: leetcode 744 寻找比目标字母大的最小字母
 * @author: Gatsby
 * @date: 2022/4/3 13:59
 */

public class _744FindSmallestLetterGreaterThanTarget {
    /**
     * @MethodName: nextGreatestLetter
     * @Parameter: [letters, target]
     * @Return char
     * @Description: 一次遍历，O(n)解法
     * @author: Gatsby
     * @date: 2022/4/3 14:03
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    /**
     * @MethodName:  nextGreatestLetterBS
     * @Parameter: [letters, target]
     * @Return char
     * @Description: letters is sorted->Binary Search
     * @author: Gatsby
     * @date:  2022/4/3 14:16
     */
    public char nextGreatestLetterBS(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n - 1]) {
            return letters[0];
        }
        int left = 0;
        int right = n - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }
}


