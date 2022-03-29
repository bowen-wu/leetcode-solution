package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = forth;
        ListNode listNode = new ReverseKGroup().reverseKGroup(first, 3);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. copy 1->2->3 4->5
        ListNode current = head;
        ListNode end = null;
        ListNode result = null;
        int index = 0;
        while (current != null) {
            index++;
            ListNode copy = new ListNode();
            ListNode copyCurrent = copy;
            boolean isFull = true;
            for (int i = 0; i < k; i++) {
                if (current == null) {
                    isFull = false;
                    break;
                }
                copyCurrent.next = new ListNode(current.val);
                current = current.next;
                copyCurrent = copyCurrent.next;
            }

            // 2. 翻转
            ListNode listNode = isFull ? reverseLinkedList(copy.next) : copy.next;

            // 3. 连接
            if (index == 1) {
                result = listNode;
                if (isFull) {
                    end = result;
                }
            } else {
                end.next = listNode;
            }
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    break;
                }
                end = end.next;
            }
            System.out.println(end);
        }
        return result;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(head.val);
        ListNode next = head.next;
        ListNode temp;

        while (next != null) {
            temp = result;
            result = next;
            next = next.next;
            result.next = temp;
        }
        return result;
    }
}
