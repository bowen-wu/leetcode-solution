package com.leetcode.solution.dynamicProgramming.singleSequence.nthTribonacciNumber.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.nthTribonacciNumber.TribonacciTemplate;

public class Tribonacci extends TribonacciTemplate {
    @Override
    public int tribonacci(int n) {
        if (n < 1) {
            return 0;
        }

        int[] memo = new int[3];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i % 3] = memo[(i - 1) % 3] + memo[(i - 2) % 3] + memo[(i - 3) % 3];
        }

        return memo[n % 3];
    }
}
