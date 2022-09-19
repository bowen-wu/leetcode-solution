package com.leetcode.solution.sort.insertionSortList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.insertionSortList.InsertionSortListTemplate;

public class InsertionSortList extends InsertionSortListTemplate {
    public ListNode insertionSortListTwo(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        while (head != null) {
            ListNode node = dummyNode;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummyNode.next;
    }

    @Override
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = head.next;
        head.next = null;
        helper(dummyNode, temp);
        return dummyNode.next;
    }

    private void helper(ListNode dummyNode, ListNode next) {
        if (next == null) {
            return;
        }

        ListNode temp = next.next;
        next.next = null;
        ListNode prev = dummyNode;
        ListNode node = dummyNode.next;
        while (node != null) {
            if (node.val > next.val) {
                prev.next = next;
                next.next = node;
                helper(dummyNode, temp);
                return;
            }
            prev = prev.next;
            node = node.next;
        }
        prev.next = next;
        helper(dummyNode, temp);
    }
}
