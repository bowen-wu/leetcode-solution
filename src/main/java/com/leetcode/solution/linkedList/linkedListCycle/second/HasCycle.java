package com.leetcode.solution.linkedList.linkedListCycle.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.linkedListCycle.HasCycleTemplate;

public class HasCycle extends HasCycleTemplate {
    @Override
    public boolean hasCycle(ListNode head) {
        // 思路：快慢指针 => 相遇了则成环 O(n) + O(1)
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
