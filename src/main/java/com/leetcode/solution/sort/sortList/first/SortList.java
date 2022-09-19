package com.leetcode.solution.sort.sortList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.sortList.SortListTemplate;

public class SortList extends SortListTemplate {
    @Override
    public ListNode sortListWithMergeSort(ListNode head) {
        // check input
        if (head == null) {
            return null;
        }

        // 只有一个节点，直接返回
        if (head.next == null) {
            return head;
        }

        ListNode middleNode = getMiddleNode(head);
        ListNode right = sortListWithMergeSort(middleNode.next);
        middleNode.next = null;
        ListNode left = sortListWithMergeSort(head);
        return mergeListNode(left, right);
    }

    private ListNode mergeListNode(ListNode first, ListNode second) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (first != null && second != null) {
            if (first.val < second.val) {
                node.next = first;
                first = first.next;
            } else {
                node.next = second;
                second = second.next;
            }
            node = node.next;
        }

        // remaining
        if (first != null) {
            node.next = first;
        }
        if (second != null) {
            node.next = second;
        }

        return dummyNode.next;
    }

    private ListNode getMiddleNode(ListNode head) {
        // 前一个中点
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    @Override
    public ListNode sortListWithQuickSort(ListNode head) {
        return null;
    }
}
