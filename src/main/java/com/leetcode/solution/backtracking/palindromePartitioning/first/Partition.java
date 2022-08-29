package com.leetcode.solution.backtracking.palindromePartitioning.first;

import com.leetcode.solution.backtracking.palindromePartitioning.PartitionTemplate;

import java.util.ArrayList;
import java.util.List;

public class Partition extends PartitionTemplate {
    @Override
    public List<List<String>> partition(String s) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, String s, int position) `
        // 4. 递归何时退出 => position >= s.length()
        // 5. 单一解何时加入解集 => position == s.length() - 1
        // 6. 剪枝 => 如果该 str 不是字符串
        // 7. 递归分解子问题到下一层 => for(int i = 0; i < s.length(); i++)
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<String>> result = new ArrayList<>();

        // check input
        if (s == null || s.length() == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<String> list = new ArrayList<>();
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, String s, int position) {
        // 递归何时退出
        if (position >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < s.length(); i++) {
            String substring = s.substring(position, i + 1);
            if (isPalindrome(substring)) {
                list.add(substring);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring) {
        if (substring.length() == 1) {
            return true;
        }
        int start = 0;
        int end = substring.length() - 1;
        while (start < end) {
            if (substring.charAt(start) != substring.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
