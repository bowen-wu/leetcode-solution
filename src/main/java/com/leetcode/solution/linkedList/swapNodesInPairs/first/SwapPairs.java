package com.leetcode.solution.linkedList.swapNodesInPairs.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.swapNodesInPairs.SwapPairsTemplate;

public class SwapPairs extends SwapPairsTemplate {
    @Override
    public ListNode swapPairs(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode traverseNode = dummyNode;
        ListNode prevNode = dummyNode;

        while (traverseNode != null) {
            ListNode check = traverseNode;
//            if (check.next == null || check.next.next == null) {
//                return dummyNode.next;
//            }
            for (int i = 0; i < 2; i++) {
                check = check.next;
                if (check == null) {
                    return dummyNode.next;
                }
            }

            ListNode currentNode = prevNode.next;
            ListNode temp = currentNode.next;
            currentNode.next = temp.next;
            temp.next = prevNode.next;
            prevNode.next = temp;

            traverseNode = currentNode;
            prevNode = currentNode;
        }
        return dummyNode.next;
    }
}
