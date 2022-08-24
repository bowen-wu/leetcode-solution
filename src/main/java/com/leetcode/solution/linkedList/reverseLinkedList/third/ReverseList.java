package com.leetcode.solution.linkedList.reverseLinkedList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedList.ReverseListTemplate;

public class ReverseList extends ReverseListTemplate {
    @Override
    public ListNode reverseList(ListNode head) {
        // 思路：头插法 => 头节点改变，使用 Dummy Node => 翻转全链表可以不使用 Dummy Node
        if (head == null) {
            return null;
        }

        ListNode node = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = node;
            node = current;
            current = next;
        }

        return node;
    }
}
