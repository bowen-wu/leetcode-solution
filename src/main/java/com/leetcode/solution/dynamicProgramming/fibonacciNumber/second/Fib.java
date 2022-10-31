package com.leetcode.solution.dynamicProgramming.fibonacciNumber.second;

import com.leetcode.solution.dynamicProgramming.fibonacciNumber.FibTemplate;

public class Fib extends FibTemplate {
    @Override
    public int fib(int n) {
        // state => F(n) 表示斐波那契数列的第n项
        // status function => F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        // Condition: F(0) = 0，F(1) = 1
        // Solution: 求 F(n)
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    @Override
    public int fibonacciTopToBottom(int n) {
        return 0;
    }

    @Override
    public int fibonacciBottomToTop(int n) {
        if (n < 2) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    @Override
    public int fibonacciScrollArray(int n) {
        if (n < 2) {
            return n;
        }

        int[] memo = new int[2];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }

        return memo[n % 2];
    }
}
