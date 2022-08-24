package com.leetcode.solution.linkedList.swapNodesInPairs.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.swapNodesInPairs.SwapPairsTemplate;

public class SwapPairs extends SwapPairsTemplate {
    @Override
    public ListNode swapPairs(ListNode head) {
        // 思路：检查够不够两个，够交换 1 次。头节点发生改变 => Dummy Node
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev != null) {
            if (prev.next == null || prev.next.next == null) {
                return dummyNode.next;
            }

            ListNode current = prev.next;
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            prev = current;
        }

        return dummyNode.next;
    }
}
