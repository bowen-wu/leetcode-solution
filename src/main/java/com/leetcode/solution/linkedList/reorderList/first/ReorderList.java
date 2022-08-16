package com.leetcode.solution.linkedList.reorderList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reorderList.ReorderListTemplate;

public class ReorderList extends ReorderListTemplate {
    public static void main(String[] args) {
        new ReorderList().reorderList(ListNode.getHead());
    }

    @Override
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = getMiddle(head);
        ListNode reverseStartNode = middle.next;
        middle.next = null;
        ListNode tail = reverseListNode(reverseStartNode);

        mergeTwoListNode(head, tail);
    }

    private void mergeTwoListNode(ListNode head, ListNode tail) {
        ListNode dummyNode = new ListNode(-1);

        while (head != null && tail != null) {
            ListNode headNext = head.next;
            ListNode tailNext = tail.next;
            dummyNode.next = head;
            dummyNode = dummyNode.next;
            dummyNode.next = tail;
            dummyNode = dummyNode.next;
            head = headNext;
            tail = tailNext;
        }

        if (head != null) {
            dummyNode.next = head;
        }

        if (tail != null) {
            dummyNode.next = tail;
        }
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public void reorderListSelf(ListNode head) {
        if (head == null) {
            return;
        }

        // 找到中点 slow
        ListNode fast = head;
        ListNode middle = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }

        // 翻转 slow.next 链表
        ListNode reverseListNodeHead = middle.next;
        middle.next = null;
        ListNode end = null;
        while (reverseListNodeHead != null) {
            ListNode temp = reverseListNodeHead.next;
            reverseListNodeHead.next = end;
            end = reverseListNodeHead;
            reverseListNodeHead = temp;
        }

        // 合并两个链表
        ListNode start = head;
        ListNode node = new ListNode(-1);
        node.next = head;

        while (end != null && start != null) {
            ListNode startNext = start.next;
            ListNode endNext = end.next;
            node.next = start;
            node = node.next;
            node.next = end;
            node = node.next;
            start = startNext;
            end = endNext;
        }

        if (end != null) {
            node.next = end;
        }
        if (start != null) {
            node.next = start;
        }
    }
}
