package com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.clmbingStairs.ClimbStairsTemplate;

public class ClimbStairs extends ClimbStairsTemplate {
    @Override
    public int climbStairs(int n) {
        // state => f(n) 代表爬到第n阶有多少种方法
        // status function => f(n) = f(n - 1) + f(n - 2)
        // condition => f(0) = 0 f(1) = 1 f(2) = 2
        // solution => get f(n)
        if (n < 3) {
            return n;
        }

        int[] memo = new int[2];
        memo[0] = 2;
        memo[1] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }

        return memo[n % 2];
    }
}
