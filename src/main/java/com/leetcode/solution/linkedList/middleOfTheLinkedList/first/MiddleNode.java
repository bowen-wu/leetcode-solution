package com.leetcode.solution.linkedList.middleOfTheLinkedList.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.middleOfTheLinkedList.MiddleNodeTemplate;

public class MiddleNode extends MiddleNodeTemplate {
    @Override
    public ListNode middleNode(ListNode head) {
        // 同向型双指针 => 快慢指针
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new MiddleNode().middleNode(head));
    }

    public ListNode middleNodeSelf(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        ListNode middleNode = head;
        int len = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            len++;
            if (len != 0 && len % 2 == 0) {
                middleNode = middleNode.next;
            }
        }
        return middleNode;
    }
}
