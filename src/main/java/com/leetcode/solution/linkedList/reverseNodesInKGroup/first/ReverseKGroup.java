package com.leetcode.solution.linkedList.reverseNodesInKGroup.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.reverseNodesInKGroup.ReverseKGroupTemplate;

public class ReverseKGroup extends ReverseKGroupTemplate {
    @Override
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode traverseNode = dummyNode;

        while (traverseNode.next != null) {
            // 判断够不够 k 个
            ListNode check = traverseNode;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) {
                    return dummyNode.next;
                }
            }

            // 翻转
            ListNode currentNode = prevNode.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = currentNode.next;
                currentNode.next = temp.next;
                temp.next = prevNode.next;
                prevNode.next = temp;
            }

            // 移动指针
            traverseNode = currentNode;
            prevNode = currentNode;
        }
        return dummyNode.next;
    }
}
