package com.leetcode.solution.linkedList.addTwoNumbersII.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.addTwoNumbersII.AddTwoNumbersTemplate;

public class AddTwoNumbers extends AddTwoNumbersTemplate {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：翻转 => 相加 => 翻转
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode list1 = reverseList(l1);
        ListNode list2 = reverseList(l2);
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int num1 = list1 == null ? 0 : list1.val;
            int num2 = list2 == null ? 0 : list2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return reverseList(dummyNode.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }
}
