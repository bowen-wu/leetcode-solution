package com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.third;

import com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.MinDistanceTemplate;

public class MinDistance extends MinDistanceTemplate {
    @Override
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            dp[i % 2][0] = i;
            for (int j = 1; j <= len2; j++) {
                dp[i % 2][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[(i - 1) % 2][j - 1] : Math.min(dp[i % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1])) + 1;
            }
        }

        return dp[len1 % 2][len2];
    }
}
