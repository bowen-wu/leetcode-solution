package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.third;

import com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.MinCutTemplate;

import java.util.Arrays;

public class MinCut extends MinCutTemplate {
    @Override
    public int minCut(String s) {
        // Ideas: backtracking + memory search
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // working with resource data => 1. sort(unique + compare)  2. set(unique + optimize find)  3. Duplicated work
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // construct memory search => int -> int => init -1
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, isValidPalindrome) - 1;
    }

    private int helper(int[] memo, String s, int position, boolean[][] isValidPalindrome) {
        // exit recursion => 不会出现
        if (position >= s.length()) {
            return Integer.MIN_VALUE;
        }

        // hit cache => care out of index when memo is array
        if (memo[position] != -1) {
            return memo[position];
        }

        // construct result
        int result = Integer.MAX_VALUE;

        // check [position, s.length() - 1] is result
        if (isValidPalindrome[position][s.length() - 1]) {
            memo[position] = 1;
            return 1;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // pruning
            if (!isValidPalindrome[position][i]) {
                continue;
            }

            // stage result => 1
            int next = helper(memo, s, i + 1, isValidPalindrome);
            result = next != Integer.MIN_VALUE ? Math.min(result, next + 1) : 1;
        }

        // update memory search
        memo[position] = result;
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

        // third | third+
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
