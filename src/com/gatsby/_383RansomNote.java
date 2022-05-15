package com.gatsby;

/**
 * @ClassName: _383RansomNote
 * @Description: leetcode 383 赎金信
 * @author: Gatsby
 * @date: 2022/5/10 19:13
 */

public class _383RansomNote {
    private boolean compareStrings(String a, int start, int end, String b) {
        int index = 0;
        for (int i = start; i <= end; ++i) {
            if (a.charAt(i) != b.charAt(index++)) return false;
        }
        return true;
    }

    public boolean canConstructStrict(String ransomNote, String magazine) {
        int n = magazine.length();
        int m = ransomNote.length();
        for (int i = 0; i <= n - m; ++i) {
            if (compareStrings(magazine, i, i + m - 1, ransomNote)) return true;
        }
        return false;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}


