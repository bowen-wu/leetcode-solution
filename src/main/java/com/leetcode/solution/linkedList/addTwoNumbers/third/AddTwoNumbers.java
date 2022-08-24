package com.leetcode.solution.linkedList.addTwoNumbers.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.addTwoNumbers.AddTwoNumbersTemplate;

public class AddTwoNumbers extends AddTwoNumbersTemplate {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：两两相加形成新节点 => 进位 carry = sum / 10，value = sum % 10 => 最终注意 carry 剩余
        // 		头节点发生改变 => Dummy Node
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
