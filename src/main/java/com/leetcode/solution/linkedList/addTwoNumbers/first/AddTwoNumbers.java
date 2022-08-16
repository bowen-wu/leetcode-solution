package com.leetcode.solution.linkedList.addTwoNumbers.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.addTwoNumbers.AddTwoNumbersTemplate;

public class AddTwoNumbers extends AddTwoNumbersTemplate {
    @Override

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

    public ListNode addTwoNumbersWithRemaining(ListNode l1, ListNode l2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            currentNode = currentNode.next;
        }

        ListNode remainingNode = l1 != null ? l1 : l2;

        while (remainingNode != null) {
            int sum = remainingNode.val + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            remainingNode = remainingNode.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
