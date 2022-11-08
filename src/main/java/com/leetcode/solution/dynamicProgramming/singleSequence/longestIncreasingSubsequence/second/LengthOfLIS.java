package com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.LengthOfLISTemplate;

import java.util.Arrays;

public class LengthOfLIS extends LengthOfLISTemplate {
    @Override
    public int lengthOfLIS(int[] nums) {
        // state => f(n) 以 nums[n] 为终点的 LIS
        // status function => f(n) = Math.max(f(1),.... f(n - 1)) + 1
        // condition => x
        // solution => 求 LIS max
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && memo[j] >= memo[i]) {
                    // update
                    memo[i] = memo[j] + 1;
                }
            }
        }

        int result = memo[0];
        for (int i = 1; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }

        return result;
    }
}
