package com.leetcode.solution.hashTable.isomorphicStrings;

/**
 * https://leetcode.cn/problems/isomorphic-strings/
 * 205. 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
abstract public class IsIsomorphicTemplate {
    abstract public boolean isIsomorphic(String s, String t);
}
