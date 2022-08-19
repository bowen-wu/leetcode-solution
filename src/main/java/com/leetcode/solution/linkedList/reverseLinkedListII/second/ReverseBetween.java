package com.leetcode.solution.linkedList.reverseLinkedListII.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseLinkedListII.ReverseBetweenTemplate;

public class ReverseBetween extends ReverseBetweenTemplate {
    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 思路：头节点可能改变 dummy node => 计数 o(n) + o(1)
        //  dummyNode 开始，先走 left - 1 步，到达 prev，之后 i = left i < right 反转
        if (head == null) {
            return null;
        }
        if (left < 1 || right < 1 || right < left) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            if (prev == null) {
                return head;
            }
            prev = prev.next;
        }

        ListNode current = prev.next;
        for (int i = left; i < right; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummyNode.next;
    }

    public ListNode reverseBetweenSelf(ListNode head, int left, int right) {
        // 思路：头节点可能改变 dummy node => 计数 O(n) + O(1)
        // 如果 num >= left && num <= right 反转
        if (head == null) {
            return null;
        }
        if (left < 1 || right < 1 || right < left) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        int len = 1;
        while (current != null) {
            if (len >= left && len < right) {
                // reverse
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            } else {
                current = current.next;
                prev = prev.next;
            }
            len++;
        }

        return dummyNode.next;
    }

}
