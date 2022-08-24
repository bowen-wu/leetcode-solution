package com.leetcode.solution.linkedList.middleOfTheLinkedList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.middleOfTheLinkedList.MiddleNodeTemplate;

public class MiddleNode extends MiddleNodeTemplate {
    @Override
    public ListNode middleNode(ListNode head) {
        // 思路：快慢双指针 => 第二个中点 => 一起走
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
}
