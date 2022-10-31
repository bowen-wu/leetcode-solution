package com.leetcode.solution.sort.insertionSortList.fourth;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.insertionSortList.InsertionSortListTemplate;

public class InsertionSortList extends InsertionSortListTemplate {
    public ListNode insertionSortListInPlace(ListNode head) {
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = dummyNode.next;

        while (node.next != null) {
            if (node.next.val >= node.val) {
                node = node.next;
            } else {
                ListNode moveNode = node.next;
                ListNode nextNode = moveNode.next;
                node.next = nextNode;
                insertNode(dummyNode, moveNode);
            }
        }

        return dummyNode.next;
    }

    private void insertNode(ListNode dummyNode, ListNode insertNode) {
        ListNode node = dummyNode;
        while (node.next != null) {
            if (node.next.val > insertNode.val) {
                insertNode.next = node.next;
                node.next = insertNode;
                return;
            } else {
                node = node.next;
            }
        }
    }

    @Override
    public ListNode insertionSortList(ListNode head) {
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);

        while (head != null) {
            ListNode node = dummyNode;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }

            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }

        return dummyNode.next;
    }
}
