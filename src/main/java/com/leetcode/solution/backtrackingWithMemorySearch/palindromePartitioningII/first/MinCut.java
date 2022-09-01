package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.first;

import com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.MinCutTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCut extends MinCutTemplate {
    private int minCutNum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new MinCut().minCutWithCurrentPartCount("aabbb"));
    }

    @Override
    public int minCut(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 处理源数据 + 创建记忆化搜索空间
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(memo, s, 0, isValidPalindrome) - 1;
    }

    public int minCutWithCurrentPartCount(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 处理源数据 + 创建记忆化搜索空间
        // 表示 => 第i个位置后的字符串分割成回文串的最小部分数
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, Integer.MAX_VALUE);
        helper(memo, s, 0, 0, isValidPalindrome);
        return minCutNum;
    }

    private void helper(int[] memo, String s, int position, int currentPartCount, boolean[][] isValidPalindrome) {
        // 递归何时退出
        if (position >= s.length()) {
            minCutNum = Math.min(currentPartCount - 1, minCutNum);
            return;
        }

        if (currentPartCount >= memo[position]) {
            return;
        }

        memo[position] = currentPartCount;

        // 递归分解子问题
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!isValidPalindrome[position][i]) {
                continue;
            }

            currentPartCount++;
            helper(memo, s, i + 1, currentPartCount, isValidPalindrome);
            currentPartCount--;
        }
    }

    private int helper(Map<Integer, Integer> memo, String s, int position, boolean[][] isValidPalindrome) {
        // 命中缓存
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // 构建结果
        int result = Integer.MAX_VALUE;

        // 何时退出递归
        if (position >= s.length()) {
            return 0;
        }

        // 判断 [position, s.length() - 1] 是否是一个结果
        if (isValidPalindrome[position][s.length() - 1]) {
            // 更新 memo
            memo.put(position, 1);
            return 1;
        }

        // 递归分解下一层
        for (int i = s.length() - 1; i >= position; i--) {
            if (!isValidPalindrome[position][i]) {
                continue;
            }
            int next = helper(memo, s, i + 1, isValidPalindrome);
            if (next != Integer.MAX_VALUE) {
                result = Math.min(next + 1, result);
            }
        }

        // 更新 memo
        memo.put(position, result);
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String s) {
        boolean[][] isValidPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            isValidPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        return isValidPalindrome;
    }
}
