package com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.longestIncreasingSubsequence.LengthOfLISTemplate;

public class LengthOfLIS extends LengthOfLISTemplate {
    @Override
    public int lengthOfLIS(int[] nums) {
        // state => f(n) 以nums[n]为结尾的递增子序列长度
        // status function => f(n) = Math.max(nums[n] > nums[j] && f(j) + 1) j == 0 -> n
        // condition => f(0) = 1
        // solution => get Math(f(n)) n == 0 -> nums.length
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] memo = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            int currentLIS = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && memo[j] + 1 > currentLIS) {
                    currentLIS = memo[j] + 1;
                }
            }
            memo[i] = currentLIS;
            max = Math.max(max, currentLIS);
        }

        return max;
    }
}
