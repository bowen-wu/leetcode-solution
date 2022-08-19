package com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeDuplicatesFromSortedList.DeleteDuplicatesTemplate;

public class DeleteDuplicates extends DeleteDuplicatesTemplate {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：头节点不会改变。遍历链表，如果下一个和当前值相同，则删除 O(n) + O(1)
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                ListNode removeNode = current.next;
                ListNode nextNode = removeNode.next;
                current.next = nextNode;
                removeNode = null;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
