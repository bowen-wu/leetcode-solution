package com.leetcode.solution.linkedList.reverseLinkedList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedList.ReverseListTemplate;

public class ReverseList extends ReverseListTemplate {
    @Override
    public ListNode reverseList(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode node = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = node;
            node = head;
            head = nextNode;
        }

        return node;
    }

    public ListNode reverseListSelf(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (head == null) {
            return null;
        }

        ListNode node = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            node = new ListNode(currentNode.val, node);
            currentNode = currentNode.next;
        }
        return node;
    }
}
