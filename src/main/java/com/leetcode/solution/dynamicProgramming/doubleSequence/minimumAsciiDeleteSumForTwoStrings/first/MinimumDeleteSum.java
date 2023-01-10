package com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.first;

import com.leetcode.solution.dynamicProgramming.doubleSequence.minimumAsciiDeleteSumForTwoStrings.MinimumDeleteSumTemplate;

public class MinimumDeleteSum extends MinimumDeleteSumTemplate {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        // state => dp[i][j] 表示 s1 从 [0, i) 和 s2 从 [0, j) 字符串相等所需删除字符的 ASCII 值
        // status function => dp[i][j] = s1.charAt(i - 1) == s2.charAt(j) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
        // condition =>
        //              dp[i][0] = dp[i - 1][0] + s1.charAt(i)
        //              dp[0][j] = dp[0][j] + s2.charAt(j)
        // solution => dp[len1][len2]
        int len1 = s1 == null ? 0 : s1.length();
        int len2 = s2 == null ? 0 : s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return dp[len1][len2];
    }
}
