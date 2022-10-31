package com.leetcode.solution.dynamicProgramming.nthTribonacciNumber.second;

import com.leetcode.solution.dynamicProgramming.nthTribonacciNumber.TribonacciTemplate;

public class Tribonacci extends TribonacciTemplate {
    @Override
    public int tribonacci(int n) {
        // state => f(n) 表示第 N 个泰波那契数
        // status function => f(n) = f(n - 1) + f(n - 2) + f(n - 3)
        // condition => f(0) = 0 f(1) = 1 f(2) = 1
        // solution => 求 f(n)
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 0;
        }

        int[] memo = new int[3];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i % 3] = memo[(i - 1) % 3] + memo[(i - 2) % 3] + memo[(i - 3) % 3];
        }
        return memo[n % 3];
    }
}
