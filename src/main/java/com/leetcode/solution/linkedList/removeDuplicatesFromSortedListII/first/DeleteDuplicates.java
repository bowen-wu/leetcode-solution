package com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode currentNode = dummyNode;

        while (currentNode != null) {
            if (currentNode.next != null && currentNode.next.next != null && currentNode.next.val == currentNode.next.next.val) {
                int value = currentNode.next.val;
                while (currentNode.next != null && currentNode.next.val == value) {
                    currentNode.next = currentNode.next.next;
                }
            } else {
                currentNode = currentNode.next;
            }
        }

        return dummyNode.next;
    }

    public ListNode deleteDuplicatesSelf(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currentNode = head;

        while (currentNode != null) {
            boolean isDelete = false;
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                isDelete = true;
                currentNode = currentNode.next;
            }

            if (isDelete) {
                currentNode = currentNode.next;
                prevNode.next = currentNode;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return dummyNode.next;
    }
}
