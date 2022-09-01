package com.leetcode.solution.backtracking.wordBreak.first;

import com.leetcode.solution.backtracking.wordBreak.WordBreakTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak extends WordBreakTemplate {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("aaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        // 处理数据源
        Set<String> set = new HashSet<>(wordDict);

        // 创建记忆化搜索空间 => -1: 初始化 0: false 1: true
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, set);
    }

    private boolean helper(int[] memo, String s, int position, Set<String> set) {
        // 递归何时退出
        if (position >= s.length()) {
            return true;
        }

        // 命中缓存
        if (memo[position] != -1) {
            return memo[position] == 1;
        }

        // 递归分解子问题
        for (int i = s.length() - 1; i >= position; i--) {
            // 阶段性结果
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                continue;
            }

            boolean result = helper(memo, s, i + 1, set);

            if (result) {
                memo[position] = 1;
                return true;
            }
        }

        memo[position] = 0;
        return false;
    }

    public boolean wordBreakOvertime(String s, List<String> wordDict) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => ` void helper(List<List<String>> result, List<String> list, String s, List<String> wordDict, int position) `
        // 4. 递归何时退出 => position >= s.length
        // 5. 单一解何时加入解集 => position == s.length
        // 6. 剪枝
        //     1. 当前 substring 不在字典中就不 add 到单一解中
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<String>> result = new ArrayList<>();

        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        helperOvertime(result, list, s, 0, set);
        return result.size() > 0;
    }

    private void helperOvertime(List<List<String>> result, List<String> list, String s, int position, Set<String> set) {
        // 递归何时退出
        if (position >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 分解子问题到下一层 + 剪枝
        for (int i = s.length() - 1; i >= position; i--) {
            // 剪枝
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                continue;
            }
            list.add(substring);
            helperOvertime(result, list, s, i + 1, set);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
