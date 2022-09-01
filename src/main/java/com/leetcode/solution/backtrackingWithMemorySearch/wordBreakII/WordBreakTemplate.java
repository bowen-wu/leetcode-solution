package com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII;

import java.util.List;

/**
 * https://leetcode.cn/problems/word-break-ii/
 * 140. 单词拆分 II
 * 给定一个字符串 s 和一个字符串字典wordDict，在字符串s中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * 示例 1：
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * <p>
 * 示例 2：
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * 示例3：
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 */
abstract public class WordBreakTemplate {
    abstract public List<String> wordBreak(String s, List<String> wordDict);
}
