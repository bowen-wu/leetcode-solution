package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        ListNode listNode = new SwapPairs().swapPairsForRecursion(first);
        System.out.println(new SwapPairs().swapPairs(first));
    }

    public ListNode swapPairsForRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(head.next.val);
        result.next = new ListNode(head.val);
        result.next.next = swapPairsForRecursion(head.next.next);
        return result;
    }

    public ListNode swapPairsForRecursion(ListNode current, ListNode next) {
        ListNode result = new ListNode(current.val);
        result.next = new ListNode(next.val);
        return result;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                temp.next = new ListNode(current.val);
                break;
            }
            temp.next = new ListNode(current.next.val);
            temp.next.next = new ListNode(current.val);
            temp = temp.next.next;
            current = current.next.next;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return Integer.toString(this.val);
    }
}
