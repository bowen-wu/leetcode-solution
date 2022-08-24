package com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：遍历，如果 current.val == next.val，找到下一个不等的，current.next = unequal
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null && current.val == next.val) {
                int value = current.val;
                while (next != null && next.val == value) {
                    next = next.next;
                }
            }
            current.next = next;
            current = next;
        }
        return head;
    }
}

