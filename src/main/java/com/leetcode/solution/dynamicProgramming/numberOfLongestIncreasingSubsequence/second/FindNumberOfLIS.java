package com.leetcode.solution.dynamicProgramming.numberOfLongestIncreasingSubsequence.second;

import com.leetcode.solution.dynamicProgramming.numberOfLongestIncreasingSubsequence.FindNumberOfLISTemplate;

public class FindNumberOfLIS extends FindNumberOfLISTemplate {
    @Override
    public int findNumberOfLIS(int[] nums) {
        // state => f(n) 表示以 nums[n] 结尾的 LIS
        // status function => f(n) = Math.max(f(0), f(1)... f(n - 1)) + 1
        // condition => x
        // solution => 求 LIS max number
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentLIS = 1;
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (memo[j] + 1 > currentLIS) {
                        currentLIS = memo[j] + 1;
                        currentResult = results[j];
                    } else if (memo[j] + 1 == currentLIS) {
                        currentResult += results[j];
                    }

                }
            }
            memo[i] = currentLIS;
            results[i] = currentResult;
        }

        int max = memo[0];
        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
                result = results[i];
            } else if (memo[i] == max) {
                result += results[i];
            }
        }
        return result;
    }
}
