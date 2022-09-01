package com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII.first;

import com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII.WordBreakTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak extends WordBreakTemplate {
    @Override
    public List<String> wordBreak(String s, List<String> wordDict) {
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return null;
        }

        // 处理原数据
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return helper(memo, s, 0, set);
    }

    private List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set) {
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // 构造结果
        List<String> result = new ArrayList<>();

        // 递归退出条件
        if (position >= s.length()) {
            return result;
        }

        if (set.contains(s.substring(position))) {
            result.add(s.substring(position));
        }

        // 递归分解子问题到下一层
        for (int i = s.length() - 1; i >= position; i--) {
            // 阶段性结果
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                continue;
            }

            List<String> next = helper(memo, s, i + 1, set);
            for (String item : next) {
                result.add(substring + " " + item);
            }
        }

        // 更新 memo
        memo.put(position, result);
        return result;
    }

    public List<String> wordBreakBacktracking(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        helper(result, list, s, 0, set);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int position, Set<String> set) {
        // 递归何时退出 + 单一解何时加入解集
        if (position >= s.length()) {
            result.add(String.join(" ", list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < s.length(); i++) {
            // 剪枝
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                continue;
            }
            list.add(substring);
            helper(result, list, s, i + 1, set);
            list.remove(list.size() - 1);
        }
    }

}
