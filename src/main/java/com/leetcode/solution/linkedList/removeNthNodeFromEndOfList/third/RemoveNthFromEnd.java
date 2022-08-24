package com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.RemoveNthFromEndTemplate;

public class RemoveNthFromEnd extends RemoveNthFromEndTemplate {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路：快慢指针找到第 n + 1 个 pre
        // 		头节点可能改变 => Dummy Node
        if (head == null) {
            return null;
        }
        if (n < 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode prev = dummyNode;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return dummyNode.next;
            }
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }

        ListNode removeNode = prev.next;
        ListNode next = removeNode.next;
        prev.next = next;
        removeNode = null;
        return dummyNode.next;
    }
}
