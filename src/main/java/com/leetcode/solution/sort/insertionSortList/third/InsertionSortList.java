package com.leetcode.solution.sort.insertionSortList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.insertionSortList.InsertionSortListTemplate;

public class InsertionSortList extends InsertionSortListTemplate {
    @Override
    public ListNode insertionSortList(ListNode head) {
        // check input
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (head != null) {
            while (node.next != null) {
                if (node.next.val > head.val) {
                    break;
                }
                node = node.next;
            }
            ListNode headNext = head.next;
            ListNode next = node.next;
            node.next = head;
            head.next = next;
            head = headNext;
            node = dummyNode;
        }

        return dummyNode.next;
    }
}
