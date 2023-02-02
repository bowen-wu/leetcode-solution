package com.leetcode.solution.dynamicProgramming.doubleSequence.longestCommonSubsequence.second;

import com.leetcode.solution.dynamicProgramming.doubleSequence.longestCommonSubsequence.LongestCommonSubsequenceTemplate;

public class LongestCommonSubsequence extends LongestCommonSubsequenceTemplate {
    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        // state => dp[i][j] 表示text1位置i和text2位置j的 LCS
        // status function => dp[i][j] = text1.charAt(i) == text2.charAt(j) ? (dp[i - 1][j - 1] + 1) : (Math.max(dp[i - 1][j], dp[i][j - 1]))
        // condition => dp[0][[0, len2]] = 0 dp[[0, len1]][0] = 0
        // solution => dp[len1][len2]
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[2][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i % 2][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? (dp[(i - 1) % 2][j - 1] + 1) : (Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]));
            }
        }

        return dp[len1 % 2][len2];
    }
}
