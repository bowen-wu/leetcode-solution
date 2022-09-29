package com.leetcode.solution.sort.sortList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.sortList.SortListTemplate;

public class SortList extends SortListTemplate {
    @Override
    public ListNode sortListWithMergeSort(ListNode head) {
        // Ideas: Merge Sort => Divider and Conquer
        //        1. get middle  2. sort  3. merge two sorted ListNode
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode left = sortListWithMergeSort(head);
        ListNode right = sortListWithMergeSort(next);
        return mergeTwoSortedListNode(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoSortedListNode(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }
            node = node.next;
        }

        // remaining
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }
        return dummyNode.next;
    }

    @Override
    public ListNode sortListWithQuickSort(ListNode head) {
        // Ideas: Quick Sort => 通过划分调整大小关系
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        int pivotValue = head.val;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = head;
        ListNode move = head.next;
        while (move != null) {
            if (move.val < pivotValue) {
                ListNode next = move.next;
                move.next = dummyNode.next;
                dummyNode.next = move;
                move = next;
                prev.next = next;
            } else {
                prev = prev.next;
                move = move.next;
            }
        }

        ListNode low = sortListWithQuickSort(dummyNode.next);
        head.next = sortListWithQuickSort(head.next);
        if (low == null) {
            return head;
        }
        ListNode last = low;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        return low;
    }
}
