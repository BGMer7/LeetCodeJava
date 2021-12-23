package com.gatsby;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2021/12/23
 * @description -- 187 重复的DNA序列
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 */


public class _187RepeatedDNASequences {
    private int n = 0;
    int N = (int) 1e5 + 10, P = 131313;
    int[] h = new int[N], p = new int[N];

    public List<String> findRepeatedDnaSequences(@NotNull String s) {
        this.n = s.length();
        // 常规的做法就是维护一个hash表，列表中存放这所有的长度为10的字符串字串，一旦重复，即为答案
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) return res;
        Map<String, Integer> times = new HashMap<>();
        for (int i = 0; i + 10 < s.length(); ++i) {
            String sub = s.substring(i, i + 10);
            times.put(sub, times.getOrDefault(sub, 0) + 1);
            if (times.get(sub) == 2) res.add(sub);
        }
        return res;
    }

    public List<String> findRepeatedDnaSequencesWithHash(@NotNull @org.jetbrains.annotations.NotNull String s) {
        // from 宫水三叶
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + 10 - 1));
            map.put(hash, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        _187RepeatedDNASequences solution = new _187RepeatedDNASequences();
        System.out.println(solution.findRepeatedDnaSequencesWithHash("AAAAAAAAAAAA"));
    }
}