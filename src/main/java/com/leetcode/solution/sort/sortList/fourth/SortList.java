package com.leetcode.solution.sort.sortList.fourth;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.sortList.SortListTemplate;

public class SortList extends SortListTemplate {
    @Override
    public ListNode sortListWithMergeSort(ListNode head) {
        // Ideas: Merge Sort
        // O(nlogn) + O(1)
        return helperWithMergeSort(head);
    }

    private ListNode helperWithMergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode second = middle.next;
        middle.next = null;
        ListNode left = helperWithMergeSort(head);
        ListNode right = helperWithMergeSort(second);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

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
        // Ideas: Quick Sort
        return helperWithQuickSort(head);
    }

    private ListNode helperWithQuickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int pivotValue = head.val;
        ListNode node = head.next;
        ListNode prev = head;

        while (node != null) {
            if (node.val < pivotValue) {
                ListNode next = node.next;
                node.next = dummyNode.next;
                dummyNode.next = node;
                node = next;
                prev.next = node;
            } else {
                node = node.next;
                prev = prev.next;
            }
        }

        ListNode right = helperWithQuickSort(head.next);
        head.next = null;
        ListNode left = helperWithQuickSort(dummyNode.next);
        head.next = right;
        return left;
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
}
