package com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.next != null && currentNode.val == currentNode.next.val) {
                ListNode removeNode = currentNode.next;
                currentNode.next = removeNode.next;
                removeNode.next = null;
            } else {
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
