package com.leetcode.solution.linkedList.linkedListCycleII.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.linkedListCycleII.DetectCycleTemplate;

public class DetectCycle extends DetectCycleTemplate {
    @Override
    public ListNode detectCycle(ListNode head) {
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
            if (fast == slow) {
                // current 和慢指针相遇的地方就是入环点
                ListNode current = head;
                while (current != slow) {
                    current = current.next;
                    slow = slow.next;
                }
                return current;
            }
        }

        return null;
    }
}
