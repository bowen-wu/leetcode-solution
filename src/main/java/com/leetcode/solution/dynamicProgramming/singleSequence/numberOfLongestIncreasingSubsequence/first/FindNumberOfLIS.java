package com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.FindNumberOfLISTemplate;

import java.util.Arrays;

public class FindNumberOfLIS extends FindNumberOfLISTemplate {
    @Override
    public int findNumberOfLIS(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(memo, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (memo[j] + 1 == memo[i]) {
                        // 又一次遇到了该长度的 LIS
                        count[i] += count[j];
                    } else if (memo[j] + 1 > memo[i]) {
                        // 找到了最新的 LIS
                        count[i] = count[j];
                        memo[i] = memo[j] + 1;
                    }
                }
            }
        }

        int maxLen = 0;
        for (int len : memo) {
            maxLen = Math.max(maxLen, len);
        }

        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            if (maxLen == memo[i]) {
                result += count[i];
            }
        }

        return result;
    }
}
