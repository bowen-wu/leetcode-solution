package com.leetcode.solution.linkedList.swapNodesInPairs.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.swapNodesInPairs.SwapPairsTemplate;

public class SwapPairs extends SwapPairsTemplate {
    @Override
    public ListNode swapPairs(ListNode head) {
        // 思路：头节点改变 dummyNode
        // 1. 判断够不够两个 2. 交换 1 次 3. 移动指针
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        while (current != null) {
            ListNode check = current;
            if (check.next == null) {
                return dummyNode.next;
            }

            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;

            prev = current;
            current = current.next;
        }

        return dummyNode.next;
    }
}
