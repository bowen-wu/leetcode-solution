package com.leetcode.solution.linkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getHead() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }
}
