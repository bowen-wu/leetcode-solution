package com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：查看 prev.next.val == prev.next.next.val => 移动指针到不重j复的地方
        // 		头节点发生改变 => Dummy Node
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                int value = prev.next.val;
                ListNode current = prev.next;
                while (current != null && current.val == value) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }
}
