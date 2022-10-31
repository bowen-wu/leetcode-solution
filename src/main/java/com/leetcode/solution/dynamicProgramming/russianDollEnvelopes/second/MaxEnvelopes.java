package com.leetcode.solution.dynamicProgramming.russianDollEnvelopes.second;

import com.leetcode.solution.dynamicProgramming.russianDollEnvelopes.MaxEnvelopesTemplate;

import java.util.Arrays;

public class MaxEnvelopes extends MaxEnvelopesTemplate {
    @Override
    public int maxEnvelopes(int[][] envelopes) {
        // 看成两个 LIS => 先排序0, 如果相等，按1倒排
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] memo = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int currentLIS = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    currentLIS = Math.max(currentLIS, memo[j] + 1);
                }
            }

            memo[i] = currentLIS;
        }

        int result = memo[0];
        for (int i = 1; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }
        return result;
    }
}
