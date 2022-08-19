package com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：头节点会改变 Dummy Node，需要记录 prev。遍历链表，两根指针，遇到相等，找得到下一个不等的 O(n) + O(1)
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int value = current.val;
                while (current != null && current.val == value) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }

        return dummyNode.next;
    }
}
