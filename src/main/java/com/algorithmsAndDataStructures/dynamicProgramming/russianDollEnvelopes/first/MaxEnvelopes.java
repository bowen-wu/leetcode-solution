package com.algorithmsAndDataStructures.dynamicProgramming.russianDollEnvelopes.first;

import com.algorithmsAndDataStructures.dynamicProgramming.russianDollEnvelopes.MaxEnvelopesTemplate;

import java.util.Arrays;

public class MaxEnvelopes extends MaxEnvelopesTemplate {
    @Override
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int len = envelopes.length;
        int[] heights = new int[len];
        for (int i = 0; i < len; i++) {
            heights[i] = envelopes[i][1];
        }

        // memo[i] 代表以 heights[i] 为结尾的最长子序列长度
        int[] memo = new int[len];

        for (int i = 0; i < len; i++) {
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (heights[j] < heights[i]) {
                    currentResult = Math.max(currentResult, memo[j] + 1);
                }
            }
            memo[i] = currentResult;
        }

        int maxLen = 0;
        for (int length : memo) {
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}
