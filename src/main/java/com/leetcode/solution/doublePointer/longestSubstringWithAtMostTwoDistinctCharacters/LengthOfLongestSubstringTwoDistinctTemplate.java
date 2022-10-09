package com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
 * 159. 至多包含两个不同字符的最长子串
 * 给你一个字符串 s ，请你找出至多包含 两个不同字符 的最长子串，并返回该子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "eceba"
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * <p>
 * 示例 2：
 * 输入：s = "ccaabbb"
 * 输出：5
 * 解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
 */
abstract public class LengthOfLongestSubstringTwoDistinctTemplate {
    abstract public int lengthOfLongestSubstringTwoDistinct(String s);
}
