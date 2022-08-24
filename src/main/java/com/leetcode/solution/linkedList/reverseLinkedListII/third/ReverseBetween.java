package com.leetcode.solution.linkedList.reverseLinkedListII.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedListII.ReverseBetweenTemplate;

public class ReverseBetween extends ReverseBetweenTemplate {
    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 思路：找到 left 前一个，翻转 right - left - 1 次
        // 		头节点可能发生改变 => Dummy Node
        if (head == null) {
            return null;
        }
        if (left > right) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // reverse
        ListNode current = prev.next;
        for (int i = left; i < right; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummyNode.next;
    }
}
