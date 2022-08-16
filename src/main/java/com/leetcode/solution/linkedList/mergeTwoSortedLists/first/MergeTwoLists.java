package com.leetcode.solution.linkedList.mergeTwoSortedLists.first;

import com.leetcode.solution.linkedList.ListNode;
import com.leetcode.solution.linkedList.mergeTwoSortedLists.MergeTwoListsTemplate;

public class MergeTwoLists extends MergeTwoListsTemplate {
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode first = list1;
        ListNode second = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        while (first != null && second != null) {
            if (first.val < second.val) {
                currentNode.next = first;
                first = first.next;
            } else {
                currentNode.next = second;
                second = second.next;
            }
            currentNode = currentNode.next;
        }

        if (first != null) {
            currentNode.next = first;
        }
        if (second != null) {
            currentNode.next = second;
        }

        return dummyNode.next;
    }
}
