package com.leetcode.solution.dynamicProgramming.doubleSequence.longestCommonSubsequence.first;

import com.leetcode.solution.dynamicProgramming.doubleSequence.longestCommonSubsequence.LongestCommonSubsequenceTemplate;

public class LongestCommonSubsequence extends LongestCommonSubsequenceTemplate {
    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        // state => dp[i][j] 表示第一串 [0, i) 和第二串 [0, j) 的 LCS
        // status function => dp[i][j] = text1[i] == text2[j] ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i][j - 1], dp[i - 1][j])
        // condition => dp[0][0, j] = 0 + dp[0 - i][0] = 0;
        // solution => dp[len1][len2]
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        dp[1][0] = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i % 2][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? (dp[(i - 1) % 2][j - 1] + 1) : Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
            }
        }

        return dp[len1 % 2][len2];
    }
}
