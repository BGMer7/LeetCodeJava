package com.gatsby;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author -- gatsby
 * @date -- 2022/1/11
 * @description -- leetcode 1036
 */


public class _1036EscapeALargeMaze {
    int limit;
    int e6_1 = 1000001;
    int hash(int x, int y){
        return x * e6_1 + y;
    }
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    HashSet<Integer> blockedSet;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        limit = n * (n-1) / 2;
        blockedSet = new HashSet<>();
        for (int[] pos : blocked) {
            blockedSet.add(hash(pos[0], pos[1]));
        }
        int sourceSurround = surroundedSize(source,target);
        if (sourceSurround == -1){
            return true;
        }
        int targetSurround = surroundedSize(target,source);
        if (targetSurround == -1){
            return true;
        }
        return sourceSurround>limit && targetSurround>limit;
    }

    int surroundedSize(int[] source, int[] target){
        int x = source[0];
        int y = source[1];
        HashSet<Integer> visited = new HashSet<>(blockedSet);
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited.add(hash(x,y));
        while (!queue.isEmpty()){
            cnt++;
            if (cnt > limit){
                // 围不住了
                return cnt;
            }
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int x1 = pos[0]+dir[0];
                int y1 = pos[1]+dir[1];
                if (x1 == target[0] && y1 == target[1]){
                    // 直接就遇到了
                    return -1;
                }
                if (isOutOfMatrix(x1,y1) || visited.contains(hash(x1,y1))){
                    continue;
                }
                visited.add(hash(x1,y1));
                queue.offer(new int[]{x1,y1});
            }
        }
        return cnt;
    }

    boolean isOutOfMatrix(int x, int y){
        return x < 0 || y < 0 || x >= 1000000 || y >= 1000000;
    }
}