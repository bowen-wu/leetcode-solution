package com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.RemoveNthFromEndTemplate;

public class RemoveNthFromEnd extends RemoveNthFromEndTemplate {
    public static void main(String[] args) {
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }

    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        int index = n + 1;
        while (index-- > 0 && fast != null) {
            fast = fast.next;
        }

        if (index > 0) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode removeNode = slow.next;
        slow.next = removeNode == null ? null : removeNode.next;
        if (removeNode != null) {
            removeNode.next = null;
        }

        return dummyNode.next;
    }
}
