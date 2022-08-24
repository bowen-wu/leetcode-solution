package com.leetcode.solution.linkedList.linkedListCycleII.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.linkedListCycleII.DetectCycleTemplate;

public class DetectCycle extends DetectCycleTemplate {
    @Override
    public ListNode detectCycle(ListNode head) {
        // 思路：先判断是否有环，如果有，起点到入环点路程为a，入环点到相遇点路程为b，相遇点到入环点路程为c
        // 		已知 slow 路程 = a + b，fast 路程 = a + b + b + c，并且 fast路程 = 2 * slow路程
        // 		=> a + b = b + c => a = c => c 处有 slow
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // has cycle
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }

        return null;
    }
}
