package com.leetcode.solution.breadthFirstSearch.wordLadder;

import java.util.List;

/**
 * https://leetcode.cn/problems/word-ladder/
 * 127. 单词接龙
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * <p>
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 */
abstract public class LadderLengthTemplate {
    abstract public int ladderLength(String beginWord, String endWord, List<String> wordList);

    abstract public int ladderLengthBilateralBFS(String beginWord, String endWord, List<String> wordList);
}
