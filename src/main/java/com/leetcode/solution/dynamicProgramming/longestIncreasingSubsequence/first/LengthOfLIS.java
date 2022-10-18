package com.leetcode.solution.dynamicProgramming.longestIncreasingSubsequence.first;

import com.leetcode.solution.dynamicProgramming.longestIncreasingSubsequence.LengthOfLISTemplate;

public class LengthOfLIS extends LengthOfLISTemplate {
    @Override
    public int lengthOfLIS(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    currentResult = Math.max(currentResult, memo[j] + 1);
                }
            }
            memo[i] = currentResult;
        }

        int max = 0;
        for (int len : memo) {
            max = Math.max(max, len);
        }
        return max;
    }
}
