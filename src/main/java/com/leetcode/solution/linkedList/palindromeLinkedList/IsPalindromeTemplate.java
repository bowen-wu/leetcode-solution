package com.leetcode.solution.linkedList.palindromeLinkedList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
abstract public class IsPalindromeTemplate {
    abstract public boolean isPalindrome(ListNode head);
}
