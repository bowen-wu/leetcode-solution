package com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.first;

import com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.MinDistanceTemplate;

public class MinDistance extends MinDistanceTemplate {
    @Override
    public int minDistance(String word1, String word2) {
        // state => dp[i][j] 表示 word1 的 [0, i) 到 word2 的 [0, j) 的最小距离
        // status function => dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] : (Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1)
        // condition => dp[0][0, len2] = [0, len2] dp[0, len1][0] = [0, len1]
        // solution => dp[len1][len2]
        if (word1 == null || word2 == null) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : (Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1);
            }
        }

        return dp[len1][len2];
    }
}
