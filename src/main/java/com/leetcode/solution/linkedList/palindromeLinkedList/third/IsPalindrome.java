package com.leetcode.solution.linkedList.palindromeLinkedList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.palindromeLinkedList.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    @Override
    public boolean isPalindrome(ListNode head) {
        // 思路：找到第一个中点，将后面的翻转，之后比较
        if (head == null) {
            return true;
        }

        ListNode middle = getMiddle(head);
        ListNode reverse = reverseList(middle.next);
        return compare(head, reverse);
    }

    private boolean compare(ListNode first, ListNode second) {
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = node;
            node = current;
            current = temp;
        }
        return node;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
