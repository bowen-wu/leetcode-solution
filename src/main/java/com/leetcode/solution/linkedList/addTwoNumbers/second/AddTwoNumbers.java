package com.leetcode.solution.linkedList.addTwoNumbers.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.addTwoNumbers.AddTwoNumbersTemplate;

public class AddTwoNumbers extends AddTwoNumbersTemplate {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：两根指针一起走，记录 carry + Dummy Node O(n) + O(1)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (first != null || second != null) {
            int num1 = first != null ? first.val : 0;
            int num2 = second != null ? second.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
