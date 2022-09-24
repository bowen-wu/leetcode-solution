package com.leetcode.solution.sort.insertionSortList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.insertionSortList.InsertionSortListTemplate;

public class InsertionSortList extends InsertionSortListTemplate {
    @Override
    public ListNode insertionSortList(ListNode head) {
        // 插入排序 => O(n^2) => 找第一个比它大的元素，插入到他的前面
        // check input
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode node = head;
        while (node != null) {
            ListNode prev = dummyNode;
            ListNode move = dummyNode.next;
            while (move != null && move.val < node.val) {
                move = move.next;
                prev = prev.next;
            }
            ListNode next = node.next;
            node.next = move;
            prev.next = node;
            node = next;
        }

        return dummyNode.next;
    }
}
