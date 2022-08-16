package com.leetcode.solution.linkedList.addTwoNumbersII;

import com.leetcode.solution.linkedList.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
abstract public class AddTwoNumbersTemplate {
    abstract public ListNode addTwoNumbers(ListNode l1, ListNode l2);
}
