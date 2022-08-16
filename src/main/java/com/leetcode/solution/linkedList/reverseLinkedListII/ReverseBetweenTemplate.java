package com.leetcode.solution.linkedList.reverseLinkedListII;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
abstract public class ReverseBetweenTemplate {
    abstract public ListNode reverseBetween(ListNode head, int left, int right);
}
