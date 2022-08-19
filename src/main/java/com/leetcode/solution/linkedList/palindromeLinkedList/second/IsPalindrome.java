package com.leetcode.solution.linkedList.palindromeLinkedList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.palindromeLinkedList.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {

    public boolean isPalindromeSingle(ListNode head) {
        // 思路：找第一个中点，翻转，比较 => 3ms + 57.5 - 57.6 MB
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode middle = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }

        ListNode current = middle.next;
        ListNode reverseNode = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = reverseNode;
            reverseNode = current;
            current = temp;
        }

        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    @Override
    public boolean isPalindrome(ListNode head) {
        // 思路：找第一个中点，翻转，比较 => 5ms + 57.7MB
        if (head == null) {
            return true;
        }
        ListNode middleNode = getMiddle(head);
        ListNode reverseNode = reverse(middleNode.next);

        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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
