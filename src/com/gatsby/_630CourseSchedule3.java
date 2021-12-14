package com.gatsby;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author -- gatsby
 * @date -- 2021/12/14
 * @description -- leetcode 630 to make course table
 */


public class _630CourseSchedule3 {

    // courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
    // course[] = [duration, deadline]
    public int scheduleCourse(int[][] courses) {
        // 根据deadline排序，ddl越前，选修这门课的优先级越高
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // 优先队列用于存放我们已经决定选修的课程，把耗时最长的那门课放在堆顶，这是性价比最低的课程，准备替换
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int days = 0; // 从第一天开始，计算选修的总学时
        for (int[] c : courses) {
            int duration = c[0];
            int ddl = c[1];

            if (days + duration <= ddl) {
                pq.add(duration);
                days += duration;
                continue;
            }

            // 如果超出了ddl，也即上面的if没有执行
            // pq.peek() > duration说明当前这门课程，比优先队列中性价比最低的课程性价比高
            // 反正也没法加一门课了，不如换一门短一点学时的课程，给后面的课程留机会
            if (!pq.isEmpty() && pq.peek() > duration) {
                // 把days原计划上的课程学时回退再加上新课程
                days -= pq.peek();
                days += duration;
                // 优先队列将性价比低的课程回退，加入新的课程
                pq.poll();
                pq.add(duration);
            }
        }
        // 优先队列中有几门课就是能上几门课
        return pq.size();
    }
}