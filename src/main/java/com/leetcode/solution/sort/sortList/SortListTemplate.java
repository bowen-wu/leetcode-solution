package com.leetcode.solution.sort.sortList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/sort-list/
 * 148. 排序链表
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * 时间复杂度：O(n * logn)
 * 空间复杂度：O(1)
 * <p>
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
abstract public class SortListTemplate {
    abstract public ListNode sortListWithMergeSort(ListNode head);

    abstract public ListNode sortListWithQuickSort(ListNode head);
}
