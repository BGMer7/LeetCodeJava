package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2021/12/22
 * @description -- 686. Repeated String Match
 */


public class _686RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        final int lenA = a.length();
        final int lenB = b.length();

        int res = lenB / lenA;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= res + 2; ++i) {
            if (stringBuilder.toString().contains(b)) {
                return i;
            }
            stringBuilder.append(a);
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        String c = "bcdabcdabc";
        System.out.println(a.indexOf(b));
        System.out.println(b.indexOf(a));
        System.out.println(b.contains(a));
        System.out.println(c.contains(a));
        _686RepeatedStringMatch solution = new _686RepeatedStringMatch();
        System.out.println(solution.repeatedStringMatch(a, b));
    }
}