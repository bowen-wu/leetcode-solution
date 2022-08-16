package com.leetcode.solution.linkedList.reverseLinkedList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
abstract public class ReverseListTemplate {
    abstract public ListNode reverseList(ListNode head);
}
