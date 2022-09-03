package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.second;

import com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioningII.MinCutTemplate;

import java.util.Arrays;

public class MinCut extends MinCutTemplate {
    @Override
    public int minCut(String s) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element position => yes
        // 3. helper => int helper(int[] memo, String s, int position)
        // 4. when exit recursion => position >= s.length()
        // 5. when single result add to solution set => no
        // 6. pruning
        // 		1. isValidPalindrome
        // 		2. split cache
        // 		3. min cut in position is 1
        // 7. recursive decomposition sub problem to next level => for loop => s.length() - 1 -> position
        // 8. how to backtracking =>
        // 9. update memo
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // working with resource data => 1. sort(重复 + 比大小) 2. Set(优化查找) 3. Duplicate Word
        // index i to index j is valid palindrome => [i, j]
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // construct memory search
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, isValidPalindrome) - 1;
    }

    private int helper(int[] memo, String s, int position, boolean[][] isValidPalindrome) {
        // exit recursion
        if (position >= s.length()) {
            return Integer.MAX_VALUE;
        }

        // hit cache
        if (memo[position] != -1) {
            return memo[position];
        }

        // construct result
        int result = Integer.MAX_VALUE;

        // pruning
        if (isValidPalindrome[position][s.length() - 1]) {
            return 1;
        }

        // recursive decomposition sub problem to next level
        for (int i = s.length() - 1; i >= position; i--) {
            if (!isValidPalindrome[position][i]) {
                // pruning
                continue;
            }

            int next = helper(memo, s, i + 1, isValidPalindrome);
            if (next != Integer.MAX_VALUE) {
                result = Math.min(result, next + 1);
            }
        }

        // update memo
        memo[position] = result;
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String str) {
        boolean[][] isValidPalindrome = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < str.length(); i++) {
            isValidPalindrome[i - 1][i] = str.charAt(i - 1) == str.charAt(i);
        }

        for (int i = str.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < str.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
