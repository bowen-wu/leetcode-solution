package com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.third;

import com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.MinimumDeleteSumTemplate;

public class MinimumDeleteSum extends MinimumDeleteSumTemplate {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1 == null ? 0 : s1.length();
        int len2 = s2 == null ? 0 : s2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= len1; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + s1.charAt(i - 1);

            for (int j = 1; j <= len2; j++) {
                char char1 = s1.charAt(i - 1);
                char char2 = s2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.min(char1 + dp[(i - 1) % 2][j], char2 + dp[i % 2][j - 1]);
                }
            }
        }

        return dp[len1 % 2][len2];
    }
}
