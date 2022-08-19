package com.leetcode.solution.linkedList.reverseNodesInKGroup.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseNodesInKGroup.ReverseKGroupTemplate;

public class ReverseKGroup extends ReverseKGroupTemplate {
    @Override
    public ListNode reverseKGroup(ListNode head, int k) {
        // 思路：头节点改变 DummyNode while + for loop
        // 	1. 使用 for 循环判断够不够 k 个 2. 使用 for 循环 reverse k - 1 次 3. 移动指针
        if (head == null) {
            return null;
        }

        if (k < 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;

        while (current != null) {
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return dummyNode.next;
                }
                check = check.next;
            }

            // reverse
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
