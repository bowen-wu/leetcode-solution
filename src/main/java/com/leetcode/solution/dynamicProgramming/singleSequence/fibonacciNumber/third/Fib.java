package com.leetcode.solution.dynamicProgramming.singleSequence.fibonacciNumber.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.fibonacciNumber.FibTemplate;

public class Fib extends FibTemplate {
    @Override
    public int fib(int n) {
        return 0;
    }

    @Override
    public int fibonacciTopToBottom(int n) {
        return 0;
    }

    @Override
    public int fibonacciBottomToTop(int n) {
        return 0;
    }

    @Override
    public int fibonacciScrollArray(int n) {
        // state => f(n) 表示第n个斐波那契数
        // status function => f(n) = f(n - 1) + f(n - 2)
        // condition => f(0) = 0 f(1) = 1
        // solution => 求f(n)
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
