package com.leetcode.solution.dynamicProgramming.singleSequence.fibonacciNumber.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.fibonacciNumber.FibTemplate;

public class Fib extends FibTemplate {
    @Override
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }

        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }

        return memo[n % 2];
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
        return 0;
    }
}
