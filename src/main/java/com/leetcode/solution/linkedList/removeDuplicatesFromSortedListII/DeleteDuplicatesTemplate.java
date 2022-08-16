package com.leetcode.solution.linkedList.removeDuplicatesFromSortedListII;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头head ，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
abstract public class DeleteDuplicatesTemplate {
    abstract public ListNode deleteDuplicates(ListNode head);

}
