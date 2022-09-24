package com.leetcode.solution.sort.sortList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.sort.sortList.SortListTemplate;

public class SortList extends SortListTemplate {
    @Override
    public ListNode sortListWithMergeSort(ListNode head) {
        // Ideas: merge sort => Divide and Conquer => O(n * logn) + O(n)
        //        找中点 + 排序 + 合并
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

    private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        // remaining
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return dummyNode.next;
    }

    private ListNode getMiddle(ListNode head) {
        // 第一个中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode result = new SortList().sortListWithQuickSort(new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(3)))));
        System.out.println(result);
    }

    @Override
    public ListNode sortListWithQuickSort(ListNode head) {
        // Ideas: quick sort => Divide and Conquer => O(nlogn) + O(1) => 分左右
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val < head.val) {
                ListNode next = node.next;
                node.next = dummyNode.next;
                dummyNode.next = node;
                node = next;
                prev.next = next;
            } else {
                node = node.next;
                prev = prev.next;
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
