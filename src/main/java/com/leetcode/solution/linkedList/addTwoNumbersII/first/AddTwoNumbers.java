package com.leetcode.solution.linkedList.addTwoNumbersII.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.addTwoNumbersII.AddTwoNumbersTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers extends AddTwoNumbersTemplate {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyNode = new ListNode(-1);
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            dummyNode.next = new ListNode(sum % 10, dummyNode.next);
        }

        if (carry > 0) {
            dummyNode.next = new ListNode(carry, dummyNode.next);
        }

        return dummyNode.next;
    }

    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode reverseL1 = reverseLinkedList(l1);
        ListNode reverseL2 = reverseLinkedList(l2);

        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        while (reverseL1 != null && reverseL2 != null) {
            int sum = reverseL1.val + reverseL2.val + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            reverseL1 = reverseL1.next;
            reverseL2 = reverseL2.next;
        }

        ListNode remainingListNode = reverseL2 != null ? reverseL2 : reverseL1;

        while (remainingListNode != null) {
            int sum = remainingListNode.val + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            remainingListNode = remainingListNode.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }

        return reverseLinkedList(dummyNode.next);
    }

    private ListNode reverseLinkedList(ListNode listNode) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = listNode;
        ListNode currentNode = listNode;

        while (currentNode != null && currentNode.next != null) {
            ListNode temp = currentNode.next;
            currentNode.next = temp.next;
            temp.next = dummyNode.next;
            dummyNode.next = temp;
        }

        return dummyNode.next;
    }
}
