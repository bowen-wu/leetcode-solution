package com.leetcode.solution.linkedList.rotateList;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
abstract public class RotateRightTemplate {
    abstract public ListNode rotateRight(ListNode head, int k);
}
