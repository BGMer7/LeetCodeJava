package com.gatsby;

import java.util.Arrays;

/**
 * @ClassName: _455AssignCookies
 * @Description:
 * @author: Gatsby
 * @date: 2022/7/25 13:34
 */

public class _455AssignCookies {
    public int findContentChildren(int[] appetite, int[] biscuits) {
        Arrays.sort(appetite);
        Arrays.sort(appetite);
        Arrays.sort(biscuits);
        int children = 0;
        int a = appetite.length;
        int b = biscuits.length;
        for (int i = 0, j = 0; i < a && j < b; ++i, ++j) {
            while (j < b && biscuits[j] < appetite[i]) ++j;
            if (j < b) children++;
        }
        return children;
    }
}


