package com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.removeNthNodeFromEndOfList.RemoveNthFromEndTemplate;

public class RemoveNthFromEnd extends RemoveNthFromEndTemplate {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路：链表结构改变，可能移除头节点 => Dummy Node -> 找到前一个即可，双指针 O(n) + O(1)
        // 边界：fast slow 都在 dummyNode，fast 走	n + 1 步，fast != null
        if (head == null || n < 1) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < n + 1; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode removeNode = slow.next;
        ListNode nextNode = removeNode.next;
        removeNode.next = null;
        slow.next = nextNode;
        return dummyNode.next;
    }
}
