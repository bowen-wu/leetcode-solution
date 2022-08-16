package com.leetcode.solution.linkedList.rotateList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.rotateList.RotateRightTemplate;

public class RotateRight extends RotateRightTemplate {
    @Override
    public ListNode rotateRight(ListNode head, int k) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode last = head;
        while (last.next != null) {
            len++;
            last = last.next;
        }

        int gap = k % len;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < gap; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        last.next = head;
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }
}
