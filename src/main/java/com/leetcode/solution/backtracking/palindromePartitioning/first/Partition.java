package com.leetcode.solution.backtracking.palindromePartitioning.first;

import com.leetcode.solution.backtracking.palindromePartitioning.PartitionTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition extends PartitionTemplate {
    public static void main(String[] args) {
        System.out.println(new Partition().partition("cbbbcc"));
    }

    @Override
    public List<List<String>> partition(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        // 处理数据源
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return helper(memo, s, 0, isValidPalindrome);
    }

    private List<List<String>> helper(Map<Integer, List<List<String>>> memo, String s, int position, boolean[][] isValidPalindrome) {
        // 命中缓存
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // 构造结果
        List<List<String>> result = new ArrayList<>();

        // 递归退出条件
        if (position >= s.length()) {
            return result;
        }

        if (isValidPalindrome[position][s.length() - 1]) {
            result.add(Collections.singletonList(s.substring(position)));
        }

        // 递归遍历下一层
        for (int i = s.length() - 1; i >= position; i--) {
            if (!isValidPalindrome[position][i]) {
                continue;
            }

            // 阶段性结果
            String substring = s.substring(position, i + 1);
            List<List<String>> next = helper(memo, s, i + 1, isValidPalindrome);

            // 构造单一结果
            for (List<String> item : next) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(substring);
                singleResult.addAll(item);
                result.add(singleResult);
            }
        }

        // 更新 memo
        memo.put(position, result);
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String s) {
        boolean[][] isValidPalindrome = new boolean[s.length()][s.length()];

        // 单个必是回文串
        for (int i = 0; i < s.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        // 判断两个字符是否是回文串
        for (int i = 1; i < s.length(); i++) {
            isValidPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        // 判断3个及以上
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        return isValidPalindrome;
    }

    public List<List<String>> partitionBackTracking(String s) {
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
