package com.leetcode.solution.linkedList.mergeTwoSortedLists.second;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.mergeTwoSortedLists.MergeTwoListsTemplate;

public class MergeTwoLists extends MergeTwoListsTemplate {
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 思路：Dummy Node + 双指针 比大小 处理剩余 O(n) + O(1)
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode first = list1;
        ListNode second = list2;
        while (first != null && second != null) {
            if (first.val > second.val) {
                ListNode nextNode = second.next;
                second.next = null;
                current.next = second;
                second = nextNode;
            } else {
                ListNode nextNode = first.next;
                first.next = null;
                current.next = first;
                first = nextNode;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }

        return dummyNode.next;
    }
}
