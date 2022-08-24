package com.leetcode.solution.linkedList.reverseNodesInKGroup.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseNodesInKGroup.ReverseKGroupTemplate;

public class ReverseKGroup extends ReverseKGroupTemplate {
    @Override
    public ListNode reverseKGroup(ListNode head, int k) {
        // 思路：check 是否够 k 个，够翻转，不够直接返回 => 翻转 k - 1 次
        // 		头节点发生改变 => Dummy Node
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        while (current != null) {
            // check k
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return dummyNode.next;
                }
                check = check.next;
            }

            // reverse k - 1
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            prev = current;
            current = current.next;
        }

        return dummyNode.next;
    }
}
