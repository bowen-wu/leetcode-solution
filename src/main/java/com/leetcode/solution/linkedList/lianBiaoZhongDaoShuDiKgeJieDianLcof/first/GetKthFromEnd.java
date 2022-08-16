package com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.GetKthFromEndTemplate;

public class GetKthFromEnd extends GetKthFromEndTemplate {
    @Override
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int gap = k;

        while (fast != null) {
            fast = fast.next;
            if (gap <= 0) {
                slow = slow.next;
            } else {
                gap--;
            }
        }

        if (gap > 0) {
            return null;
        }
        return slow;
    }
}
