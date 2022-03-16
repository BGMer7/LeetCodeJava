package com.gatsby.tencent.list;

import com.gatsby.ListNode;

/**
 * @ClassName: _237DeleteNodeInLinkedList
 * @Description: leetcode 237 删除链表中的节点
 * @author: Gatsby
 * @date: 2022/3/16 16:16
 */

public class _237DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // 先获取到这个数值，也就是克隆下一个
        node.val = node.next.val;
        // 然后直接跳过下一个，直接指向下下个
        node.next = node.next.next;
    }
}


