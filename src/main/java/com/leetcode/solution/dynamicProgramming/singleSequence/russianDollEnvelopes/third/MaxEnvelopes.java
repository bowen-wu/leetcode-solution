package com.leetcode.solution.dynamicProgramming.singleSequence.russianDollEnvelopes.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.russianDollEnvelopes.MaxEnvelopesTemplate;

import java.util.Arrays;

public class MaxEnvelopes extends MaxEnvelopesTemplate {
    @Override
    public int maxEnvelopes(int[][] envelopes) {
        // Ideas: sort x 正序，x 相等 y 逆序 => LIS
        // state => f(n) 表示以 envelopes[n] 结尾的最长的信封
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        });

        int len = envelopes.length;
        int[] memo = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            int current = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && memo[j] + 1 > current) {
                    current = memo[j] + 1;
                }
            }

            memo[i] = current;
            result = Math.max(result, current);
        }

        return result;
    }
}
