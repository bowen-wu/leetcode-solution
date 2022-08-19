package com.leetcode.solution.linkedList.linkedListCycleII.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.linkedListCycleII.DetectCycleTemplate;

public class DetectCycle extends DetectCycleTemplate {
    @Override
    public ListNode detectCycle(ListNode head) {
        // 思路：首先判断是否成环 => 快慢指针 => 如果成环，找到入环点 O(n) + O(1)
        //  设起点到入环点距离为 a，入环点到 fast slow 相遇点为 b，相遇点到入环点为 c。根据 fast slow 路程可知 => Sfast = 2Sslow
        // 	=> a + b + n * (b + c) = 2 * (a + b) -> a = (n - 1) * (b + c) + c
        // 	=> 新指针和 slow 指针一起走，汇合的地方就是入环点
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 有环
                ListNode newPoint = head;
                while (newPoint != slow) {
                    newPoint = newPoint.next;
                    slow = slow.next;
                }

                return newPoint;
            }
        }
        return null;
    }
}
