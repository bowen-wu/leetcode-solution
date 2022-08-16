package com.leetcode.solution.linkedList.reverseLinkedListII.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedListII.ReverseBetweenTemplate;

public class ReverseBetween extends ReverseBetweenTemplate {
    public static void main(String[] args) {
        System.out.println(new ReverseBetween().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
    }

    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }
        if (left > right) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;

        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
        }

        ListNode reverseStartNode = prevNode.next;

        for (int i = left; i < right; i++) {
            ListNode temp = reverseStartNode.next;
            reverseStartNode.next = temp.next;
            temp.next = prevNode.next;
            prevNode.next = temp;
        }

        return dummyNode.next;
    }

    public ListNode reverseBetweenSelf(ListNode head, int left, int right) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }
        if (left > right) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode currentNode = head;
        ListNode leftPrevNode = dummyNode;
        ListNode rightNextNode = null;
        ListNode reverseFirstNode = null;
        ListNode reverseLastNode = null;
        int num = 0;

        while (currentNode != null) {
            num++;
            if (num == left) {
                reverseLastNode = currentNode;
            }
            if (num == right) {
                rightNextNode = currentNode.next;
            }
            if (num >= left && num <= right) {
                ListNode nextNode = currentNode.next;
                currentNode.next = reverseFirstNode;
                reverseFirstNode = currentNode;
                currentNode = nextNode;
            } else {
                if (num < left) {
                    leftPrevNode = leftPrevNode.next;
                }
                currentNode = currentNode.next;
            }
        }
        leftPrevNode.next = reverseFirstNode;
        reverseLastNode.next = rightNextNode;
        return dummyNode.next;
    }
}
