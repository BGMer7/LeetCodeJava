package com.gatsby;

/**
 * @ClassName: _1103DistributeCandiesToPeople
 * @Description: leetcode 1103 分糖果II
 * @author: Gatsby
 * @date: 2022/7/18 16:40
 */

public class _1103DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribution = new int[num_people];
        int pos = 0;
        int candy = 1;
        while (candies >= 0) {
            if (pos == num_people) pos = 0;
            if (candies >=  candy) {
                distribution[pos] += candy;
                candies -= candy;
                pos++;
                candy++;
            }else {
                distribution[pos] += candies;
                return distribution;
            }
        }
        return distribution;
    }
}


