package com.gatsby;

/**
 * @ClassName: _1688CountOfMatchesInTournament
 * @Description: leetcode 1688
 * @author: Gatsby
 * @date: 2022/1/26 10:06
 */

public class _1688CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n / 2 != 0) {
            if (n % 2 == 0) {
                res += n / 2;
                n /= 2;
            } else {
                res += (n / 2);
                n = (n / 2) + 1;
            }
        }
        return res;
    }
}


