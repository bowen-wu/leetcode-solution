package com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.ClimbStairsTemplate;

public class ClimbStairs extends ClimbStairsTemplate {
    @Override
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public int climbStairsScrollArray(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memo = new int[2];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }
        return memo[n % 2];
    }
}
