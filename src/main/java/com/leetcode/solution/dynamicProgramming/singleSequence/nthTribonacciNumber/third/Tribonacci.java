package com.leetcode.solution.dynamicProgramming.singleSequence.nthTribonacciNumber.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.nthTribonacciNumber.TribonacciTemplate;

public class Tribonacci extends TribonacciTemplate {
    @Override
    public int tribonacci(int n) {
        // state => T(n) 代表第n个泰波那契数
        // status function => T(n) = T(n - 1) + T(n - 2) + T(n - 3);
        // condition => T(0) = 0 T(1) = 1 T(2) = 1
        // solution => get T(n)
        if (n < 2) {
            return n;
        }

        if (n == 2) {
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
