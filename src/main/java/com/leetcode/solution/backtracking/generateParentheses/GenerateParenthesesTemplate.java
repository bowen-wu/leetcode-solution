package com.leetcode.solution.backtracking.generateParentheses;

import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
abstract public class GenerateParenthesesTemplate {
    abstract public List<String> generateParenthesis(int n);
}
