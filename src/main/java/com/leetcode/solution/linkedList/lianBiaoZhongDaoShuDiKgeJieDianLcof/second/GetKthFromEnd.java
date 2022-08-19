package com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.lianBiaoZhongDaoShuDiKgeJieDianLcof.GetKthFromEndTemplate;

public class GetKthFromEnd extends GetKthFromEndTemplate {
    @Override
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 思路：快慢指针 => 快指针先走，之后快慢一起走。O(n) + O(1)
        // 边界：fast 到 null，先走 k 步
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
