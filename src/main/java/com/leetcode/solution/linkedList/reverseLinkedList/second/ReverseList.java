package com.leetcode.solution.linkedList.reverseLinkedList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedList.ReverseListTemplate;

public class ReverseList extends ReverseListTemplate {
    @Override
    public ListNode reverseList(ListNode head) {
        // 思路：头插 O(n) + O(1)
        if (head == null) {
            return null;
        }

        ListNode current = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current;
            current = head;
            head = next;
        }

        return current;
    }
}
