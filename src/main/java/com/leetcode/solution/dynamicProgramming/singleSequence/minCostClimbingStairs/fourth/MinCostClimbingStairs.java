package com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.MinCostClimbingStairsTemplate;

public class MinCostClimbingStairs extends MinCostClimbingStairsTemplate {
    @Override
    public int minCostClimbingStairs(int[] cost) {
        // state => dp[i] 表示爬到第 i 层台阶的花费
        // status function => dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        // condition => dp[0] = 0 dp[1] = 0
        // solution => dp[cost.length]
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int len = cost.length;
        int[] memo = new int[2];
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.min(memo[(i - 1) % 2] + cost[i - 1], memo[(i - 2) % 2] + cost[i - 2]);
        }

        return memo[len % 2];
    }
}
