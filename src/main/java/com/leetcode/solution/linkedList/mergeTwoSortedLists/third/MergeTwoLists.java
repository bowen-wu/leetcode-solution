package com.leetcode.solution.linkedList.mergeTwoSortedLists.third;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.mergeTwoSortedLists.MergeTwoListsTemplate;

public class MergeTwoLists extends MergeTwoListsTemplate {
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 思路：双指针比较，注意剩余
        // 		头节点改变 => Dummy Node
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummyNode.next;
    }
}
