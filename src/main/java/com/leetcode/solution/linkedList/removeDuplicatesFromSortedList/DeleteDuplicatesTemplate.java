package com.leetcode.solution.linkedList.removeDuplicatesFromSortedList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
abstract public class DeleteDuplicatesTemplate {
    abstract public ListNode deleteDuplicates(ListNode head);
}
