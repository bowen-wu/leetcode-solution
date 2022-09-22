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

    public static void main(String[] args) {
        System.out.println(new SortList().sortListWithQuickSort(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
    }

    @Override
    public ListNode sortListWithQuickSort(ListNode head) {
        // Ideas: quick sort
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;

        // 此处不需要连接 head
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = head;

        // traversal
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

        // 可能没有低区
        if (low == null) {
            return head;
        }
        ListNode lowNode = low;
        while (lowNode.next != null) {
            lowNode = lowNode.next;
        }
        lowNode.next = head;

        return low;
    }
}
