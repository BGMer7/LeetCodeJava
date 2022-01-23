package com.gatsby;

import java.util.*;

/**
 * @author -- gatsby
 * @date -- 2022/1/23
 * @description -- leetcode 2034 股票价格波动
 */


public class _2034StockPriceFluctuation {
    private int maxTimestamp;
    // 记录每个时间对应的股价
    private HashMap<Integer, Integer> timePriceMap;
    // 记录每个价格出现过多少次
    // 其实我们存储的信息是[2,3,3,4,4,5,5,5]形式
    // 但是为了利用有序集合，价格个数对我们无用，我们只需要关心是否存在这个价格
    // 所以其实我们存的信息是[<2,1>,<3,2>,<4,2>,<5,3>]
    // 如果价格为2的股票被修正，那么我们需要将2这个key移除出Map
    private TreeMap<Integer, Integer> priceCntMap;

    public _2034StockPriceFluctuation() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<>();
        priceCntMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(timestamp, maxTimestamp);
        int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
        // 更新timePriceMap表不需要考虑是否已经存在
        timePriceMap.put(timestamp, price);

        if (prevPrice != 0) {
            priceCntMap.put(prevPrice, priceCntMap.get(prevPrice) - 1);
            if (priceCntMap.get(prevPrice) - 1 == 0) {
                priceCntMap.remove(prevPrice);
            }
        }
        priceCntMap.put(price, priceCntMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        return priceCntMap.lastKey();
    }

    public int minimum() {
        return priceCntMap.firstKey();
    }

    public static void main(String[] args) {
        _2034StockPriceFluctuation solution = new _2034StockPriceFluctuation();
        solution.update(1, 10);
        solution.update(2, 5);
        System.out.println(solution.current());
        System.out.println(solution.maximum());
        solution.update(1, 3);
        System.out.println(solution.maximum());
        solution.update(4, 2);
        System.out.println(solution.minimum());

        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<int[]> pqMinArray = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pqMaxArray = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        pqMax.offer(1);
        pqMax.offer(-1);
        pqMax.offer(2);
        System.out.println(pqMax.peek());

        pqMin.offer(1);
        pqMin.offer(2);
        pqMin.offer(-1);
        System.out.println(pqMin.peek());

        pqMaxArray.offer(new int[]{2, 1});
        pqMaxArray.offer(new int[]{2, 2});
        pqMaxArray.offer(new int[]{4, 2});
        pqMaxArray.offer(new int[]{5, 3});
        System.out.println(Arrays.toString(pqMaxArray.peek()));

        pqMinArray.offer(new int[]{2, 1});
        pqMinArray.offer(new int[]{3, 2});
        pqMinArray.offer(new int[]{4, 2});
        pqMinArray.offer(new int[]{5, 3});
        System.out.println(Arrays.toString(pqMinArray.peek()));

        assert pqMaxArray.peek() != null;
        System.out.println(pqMaxArray.peek()[0]);
    }
}