package com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.ClimbStairsTemplate;

public class ClimbStairs extends ClimbStairsTemplate {
    @Override
    public int climbStairs(int n) {
        // state => dp[i] 表示共有 dp[i] 种方法到达第i阶
        // status function => dp[i] = dp[i - 1] + dp[i - 2]
        // condition => dp[0] = 1 dp[1] = 1
        // solution => dp[n]
        if (n < 1) {
            return 0;
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
