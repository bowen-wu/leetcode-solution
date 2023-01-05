package com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.LengthOfLISTemplate;

public class LengthOfLIS extends LengthOfLISTemplate {
    @Override
    public int lengthOfLIS(int[] nums) {
        // state => dp[i] 以 nums[i] 为结尾的最长递增子序列
        // status function => dp[i] = Math.max(dp[0], dp[1]...dp[i - 1]) + 1 && 该值小于 nums[i]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        int result = 0;

        for (int i = 0; i < len; i++) {
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > currentResult) {
                    currentResult = dp[j] + 1;
                }
            }

            dp[i] = currentResult;
            result = Math.max(result, currentResult);
        }

        return result;
    }
}
