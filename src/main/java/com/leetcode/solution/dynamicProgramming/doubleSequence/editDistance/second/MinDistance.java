package com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.second;

import com.leetcode.solution.dynamicProgramming.doubleSequence.editDistance.MinDistanceTemplate;

public class MinDistance extends MinDistanceTemplate {
    @Override
    public int minDistance(String word1, String word2) {
        // state => dp[i][j] 表示 word1 [0, i] 转化成 word2 [0, j] 的最少操作数
        // status function => dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : (Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1], [j - 1])) + 1)
        // condition => dp[0][[0, len2]] = j  dp[[0, len1]][0] = i
        // solution => dp[len1][len2]
        // 滚动数组
        if (word1 == null && word2 == null) {
            return 0;
        }

        if (word1 == null) {
            return word2.length();
        }

        if (word2 == null) {
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
                dp[i % 2][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[(i - 1) % 2][j - 1] : (Math.min(dp[(i - 1) % 2][j], Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j - 1])) + 1);
            }
        }

        return dp[len1 % 2][len2];
    }
}
