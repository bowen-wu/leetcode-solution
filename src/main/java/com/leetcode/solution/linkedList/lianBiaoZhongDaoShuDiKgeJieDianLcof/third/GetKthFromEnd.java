package com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.GetKthFromEndTemplate;

public class GetKthFromEnd extends GetKthFromEndTemplate {
    @Override
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 思路：快慢双指针
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
