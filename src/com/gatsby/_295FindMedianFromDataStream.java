package com.gatsby;

import java.util.PriorityQueue;

/**
 * @ClassName: _95FindMedianFromDataStream
 * @Description: leetcode 295 数据流的中位数
 * @author: Gatsby
 * @date: 2022/3/21 22:06
 */

public class _295FindMedianFromDataStream {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public _295FindMedianFromDataStream() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        q.add(20);
        q.add(30);
        q.add(10);
        System.out.println(q.peek());
        // 30
    }
}


