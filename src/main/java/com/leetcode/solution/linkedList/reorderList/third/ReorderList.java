package com.leetcode.solution.linkedList.reorderList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reorderList.ReorderListTemplate;

public class ReorderList extends ReorderListTemplate {
    @Override
    public void reorderList(ListNode head) {
        // 思路：找第一个中点 => 将中点后面的翻转 => 拼接两个链表
        if (head == null) {
            return;
        }

        ListNode middle = getMiddle(head);
        ListNode reverseNode = reverse(middle.next);
        middle.next = null;
        merge(head, reverseNode);
    }

    private void merge(ListNode first, ListNode second) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            current.next = first;
            current = current.next;
            current.next = second;
            current = current.next;
            first = firstNext;
            second = secondNext;
        }
        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode node = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = node;
            node = current;
            current = temp;
        }
        return node;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
