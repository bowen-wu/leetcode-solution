package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioning;

import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
abstract public class PartitionTemplate {
    abstract public List<List<String>> partition(String s);
}
