package com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.second;

import com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.MinimumDeleteSumTemplate;

public class MinimumDeleteSum extends MinimumDeleteSumTemplate {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        // state => dp[i][j] 表示s1在[0, i]和s2在[0, j]处使两个字符串相等所需删除字符的 ASCII 值的最小和
        // status function => dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + s1[i], dp[i][j - 1] + s2[j])
        // condition => dp[0][0] = 0 dp[0][j] = dp[0][j - 1] + s2[j]  dp[i][0] = dp[i - 1][0] + s1[i]
        // solution => dp[len1][len2]
        // 滚动数组
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= len1; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + s1.charAt(i - 1);

            for (int j = 1; j <= len2; j++) {
                dp[i % 2][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[(i - 1) % 2][j - 1] : Math.min(dp[(i - 1) % 2][j] + s1.charAt(i - 1), dp[i % 2][j - 1] + s2.charAt(j - 1));
            }
        }

        return dp[len1 % 2][len2];
    }
}
