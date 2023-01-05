package com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.FindNumberOfLISTemplate;

public class FindNumberOfLIS extends FindNumberOfLISTemplate {
    @Override
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        int[] numbers = new int[len];
        int maxLength = 0;

        for (int i = 0; i < len; i++) {
            int currentResult = 1;
            int currentNum = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > currentResult) {
                        currentResult = dp[j] + 1;
                        currentNum = numbers[j];
                    } else if (dp[j] + 1 == currentResult) {
                        currentNum += numbers[j];
                    }
                }
            }

            dp[i] = currentResult;
            numbers[i] = currentNum;
            maxLength = Math.max(maxLength, currentResult);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLength) {
                result += numbers[i];
            }
        }

        return result;
    }
}
