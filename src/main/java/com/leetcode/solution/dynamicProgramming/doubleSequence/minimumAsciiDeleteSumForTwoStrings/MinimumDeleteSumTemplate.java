package com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings;

/**
 * https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1和s2，返回 使两个字符串相等所需删除字符的ASCII值的最小和。
 * <p>
 * 示例 1:
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * <p>
 * 示例2:
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 */
abstract public class MinimumDeleteSumTemplate {
    abstract public int minimumDeleteSum(String s1, String s2);
}
