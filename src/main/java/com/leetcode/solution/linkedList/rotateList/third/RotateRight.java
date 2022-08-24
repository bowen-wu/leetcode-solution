package com.leetcode.solution.linkedList.rotateList.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.rotateList.RotateRightTemplate;

public class RotateRight extends RotateRightTemplate {
    @Override
    public ListNode rotateRight(ListNode head, int k) {
        // 思路：获取 length，k % length 就是头节点移动的距离 => 找到 prev + last => 快慢双指针
        //  	头节点发生改变 => Dummy Node
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode last = dummyNode;
        ListNode prev = dummyNode;
        for (int i = 0; i < k % length; i++) {
            last = last.next;
        }

        while (last.next != null) {
            last = last.next;
            prev = prev.next;
        }

        last.next = dummyNode.next;
        dummyNode.next = prev.next;
        prev.next = null;

        return dummyNode.next;
    }
}
