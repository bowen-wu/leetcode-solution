package com.leetcode.solution.linkedList.linkedListCycle.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.linkedListCycle.HasCycleTemplate;

public class HasCycle extends HasCycleTemplate {
    @Override
    public boolean hasCycle(ListNode head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
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
