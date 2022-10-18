package com.leetcode.solution.dynamicProgramming.nthTribonacciNumber.first;

import com.leetcode.solution.dynamicProgramming.nthTribonacciNumber.TribonacciTemplate;

public class Tribonacci extends TribonacciTemplate {
    @Override
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
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
