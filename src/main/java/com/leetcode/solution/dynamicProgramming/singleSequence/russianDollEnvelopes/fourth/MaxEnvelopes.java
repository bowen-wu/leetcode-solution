package com.leetcode.solution.dynamicProgramming.singleSequence.russianDollEnvelopes.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.russianDollEnvelopes.MaxEnvelopesTemplate;

import java.util.Arrays;

public class MaxEnvelopes extends MaxEnvelopesTemplate {
    public int maxEnvelopes(int[][] envelopes) {
        // [5,4],[6,4],[6,7],[2,3]
        // [2,3],[5,4],[6,7],[6,4]
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> b[0] != a[0] ? (b[0] - a[0]) : (a[1] - b[1]));

        int len = envelopes.length;
        int[] dp = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] > envelopes[i][1] && dp[j] + 1 > currentResult) {
                    currentResult = dp[j] + 1;
                }
            }

            dp[i] = currentResult;
            result = Math.max(result, currentResult);
        }

        return result;
    }
}
