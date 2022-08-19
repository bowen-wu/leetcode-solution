package com.leetcode.solution.linkedList.rotateList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.rotateList.RotateRightTemplate;

public class RotateRight extends RotateRightTemplate {
    @Override
    public ListNode rotateRight(ListNode head, int k) {
        // 思路：get length => k % length => 倒数第 k % length + 1 的点 => 连接
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return head;
        }

        int length = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            lenNode = lenNode.next;
            length++;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k % length; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }
}
