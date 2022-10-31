package com.leetcode.solution.dynamicProgramming.clmbingStairs.second;

import com.leetcode.solution.dynamicProgramming.clmbingStairs.ClimbStairsTemplate;

public class ClimbStairs extends ClimbStairsTemplate {
    @Override
    public int climbStairs(int n) {
        // State => f(n) 表示上到第n阶的可能总数
        // status function => f(n) = f(n - 1) + f(n - 2)
        // condition => f(1) = 1 f(2) = 2
        // solution => 求 f(n)
        if (n < 3) {
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
