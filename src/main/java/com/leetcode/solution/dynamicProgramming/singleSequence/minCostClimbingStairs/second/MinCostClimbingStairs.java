package com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.MinCostClimbingStairsTemplate;

public class MinCostClimbingStairs extends MinCostClimbingStairsTemplate {
    @Override
    public int minCostClimbingStairs(int[] cost) {
        // state => f(n) 表示爬到第n阶的最小花费
        // status function => f(n) = Math.min(f(n - 1) + cost[n - 1], f(n - 2) + cost[n - 2])
        // condition => x
        // solution => f(cost.length)
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
