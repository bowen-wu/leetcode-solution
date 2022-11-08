package com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.numberOfLongestIncreasingSubsequence.FindNumberOfLISTemplate;

public class FindNumberOfLIS extends FindNumberOfLISTemplate {
    @Override
    public int findNumberOfLIS(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] memo = new int[len];
        int[] sequence = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            int currentLIS = 1;
            int currentSequence = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (memo[j] + 1 > currentLIS) {
                        currentLIS = memo[j] + 1;
                        currentSequence = sequence[j];
                    } else if (memo[j] + 1 == currentLIS) {
                        currentSequence += sequence[j];
                    }
                }
            }
            memo[i] = currentLIS;
            max = Math.max(max, currentLIS);
            sequence[i] = currentSequence;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (memo[i] == max) {
                result += sequence[i];
            }
        }

        return result;
    }
}
