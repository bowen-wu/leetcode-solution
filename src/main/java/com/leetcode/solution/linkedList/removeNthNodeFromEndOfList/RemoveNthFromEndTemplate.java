package com.leetcode.solution.linkedList.removeNthNodeFromEndOfList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
abstract public class RemoveNthFromEndTemplate {
    abstract public ListNode removeNthFromEnd(ListNode head, int n);
}
