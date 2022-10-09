package com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 * 340. 至多包含 K 个不同字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出至多包含 k 个 不同 字符的最长子串，并返回该子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "eceba", k = 2
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * <p>
 * 示例 2：
 * 输入：s = "aa", k = 1
 * 输出：2
 * 解释：满足题目要求的子串是 "aa" ，长度为 2 。
 */
abstract public class LengthOfLongestSubstringKDistinctTemplate {
    abstract public int lengthOfLongestSubstringKDistinct(String s, int k);
}
