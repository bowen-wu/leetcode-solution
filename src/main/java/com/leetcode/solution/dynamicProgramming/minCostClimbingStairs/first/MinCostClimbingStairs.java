package com.leetcode.solution.dynamicProgramming.minCostClimbingStairs.first;

import com.leetcode.solution.dynamicProgramming.minCostClimbingStairs.MinCostClimbingStairsTemplate;

public class MinCostClimbingStairs extends MinCostClimbingStairsTemplate {
    @Override
    public int minCostClimbingStairs(int[] cost) {
        // check input
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] memo = new int[2];
        for (int i = 2; i <= cost.length; i++) {
            memo[i % 2] = Math.min(memo[(i - 1) % 2] + cost[i - 1], memo[(i - 2) % 2] + cost[i - 2]);
        }

        return memo[cost.length % 2];
    }
}
