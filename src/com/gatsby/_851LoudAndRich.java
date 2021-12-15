package com.gatsby;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author -- gatsby
 * @date -- 2021/12/15
 * @description -- leetcode 851 Graph
 */


public class _851LoudAndRich {
    private void dfs(int i, int[] res, int[] quiet, List<Integer>[] out) {
        // 说明这个i已经之前就遍历过了
        // 已经走过的路，只需要取现成的结果就行
        if (res[i] != -1) {
            return;
        }
        // 最少res可以填上自己（一定有一个比自己有钱的人，即自己）
        res[i] = i;
        for (int next : out[i]) {
            dfs(next, res, quiet, out);
            if (quiet[res[next]] < quiet[res[i]])
                res[i] = res[next];
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final int n = quiet.length;
        int[] inDegree = new int[n];
        List<Integer>[] out = new List[n];

        for (int i = 0; i < n; ++i)
            out[i] = new ArrayList<>();


        for (int[] arr : richer) {
            ++inDegree[arr[1]];
            out[arr[1]].add(arr[0]);
        }

        /*
        dfs解法的inDegree和out
        for (int[] arr : richer) {
            ++inDegree[arr[0]];
            out[arr[0]].add(arr[1]);
        }
         */

        int[] res = new int[n];

        /**
         * 如果采用dfs搜索，那么只需要将整个res数组全部先赋值-1
         * 那么剩下的不是-1的就代表之前已经遍历过，就不用再走
         * Arrays.fill(res, -1);
         * for (int i = 0; i < n; ++i)
         *     dfs(i, res, quiet, out);
         */

        // 拓扑排序写法
        Queue<Integer> q = new ArrayDeque<>();
        // 正因为题目中给出了可以逻辑自恰，所以这是一个无环图，所以必定有一个入度为0，即最穷的人
        for (int i = 0; i < n; ++i)
            if (inDegree[i] == 0)
                q.offer(i);


        while (!q.isEmpty()) {
            int x = q.poll();
            for (int next : out[x]) {
                if (quiet[res[x]] < quiet[res[next]])
                    res[next] = res[x];

                if (--inDegree[next] == 0)
                    q.offer(next);
            }
        }
        return res;
    }
}