package com.leetcode.solution.linkedList.palindromeLinkedList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.palindromeLinkedList.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    @Override
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找中点
        ListNode fast = head;
        ListNode middle = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }

        // 翻转
        ListNode reverse = fast == null ? middle : middle.next;
        ListNode prev = null;
        while (reverse != null) {
            ListNode temp = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = temp;
        }

        // 比较
        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
