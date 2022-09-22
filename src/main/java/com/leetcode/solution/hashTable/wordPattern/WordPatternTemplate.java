package com.leetcode.solution.hashTable.wordPattern;

/**
 * https://leetcode.cn/problems/word-pattern/
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串s，判断 s 是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
abstract public class WordPatternTemplate {
    abstract public boolean wordPattern(String pattern, String s);
}
