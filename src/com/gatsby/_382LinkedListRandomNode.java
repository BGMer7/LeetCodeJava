package com.gatsby;

import java.util.Random;

/**
 * @author -- gatsby
 * @date -- 2022/1/16
 * @description -- leetcode 382 链表随机节点
 */

public class _382LinkedListRandomNode {
    /* private List<Integer> list;

    public _382LinkedListRandomNode(ListNode head) {
        // 一开始是想因为本身这就是一个链表，如果使用linked list 会更好，但是getRandom还是要随机访问
        // list = new LinkedList<>();
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }*/

    /*
    蓄水池采样算法 reservoir sampling
    采样问题最主要的是要做到公平，也就是保证每个元素被抽到的概率是相等的。
    考虑如下三个问题：
    1. 从100000份电话报告中，抽取1000份进行分析
    2. 从一本很厚的电话簿中，抽取1000人进行姓名统计
    3. 从Google中搜索"Ken Thompson"，从中抽取100个结果看看哪些是今年的

    第一个情况是已知样本总量的，，第二、三种情况是不知道数据整体规模有多大的。
    如果要一次遍历，时间复杂度是O(n)，如果要将数据全部保存下来，那么空间复杂度也达到了o(n)

    蓄水池采样算法的思路：
    假设数据序列的规模为 n，需要采样的数量的为 k。
    首先构建一个可容纳 k 个元素的数组，将序列的前 k 个元素放入数组中。
    然后从第 k+1 个元素开始，以 k/n 的概率来决定该元素是否被替换到数组中（数组中的元素被替换的概率是相同的）。
    当遍历完所有元素之后，数组中剩下的元素即为所需采取的样本。
     */

    private ListNode head;

    public _382LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random random = new Random();
        int i = 1;
        int res = 0;
        while (head != null) {
            if (random.nextInt(i) == 0) {
                res = head.val;
            }
            head = head.next;
            ++i;
        }
        return res;
    }


}