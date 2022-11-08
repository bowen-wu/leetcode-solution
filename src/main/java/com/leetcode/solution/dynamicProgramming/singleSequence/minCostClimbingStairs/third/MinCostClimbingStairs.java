package com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.minCostClimbingStairs.MinCostClimbingStairsTemplate;

public class MinCostClimbingStairs extends MinCostClimbingStairsTemplate {
    @Override
    public int minCostClimbingStairs(int[] cost) {
        // state => f(n) 表示爬到第n阶的最低花费
        // status function => f(n) = min(f(n - 1) + cost[n - 1], f(n - 2)
        // condition => f(0) = 0 f(1) = 0
        // solution => get f(cost.length)
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
