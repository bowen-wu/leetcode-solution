package com.leetcode.solution.linkedList.middleOfTheLinkedList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.middleOfTheLinkedList.MiddleNodeTemplate;

public class MiddleNode extends MiddleNodeTemplate {
    @Override
    public ListNode middleNode(ListNode head) {
        // 思路：快慢指针 => 两个中间节点，返回第二个，fast、slow 一起走 O(n) O(1)
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
