package com.leetcode.solution.recurision.fibonacci.first;

import com.leetcode.solution.recurision.fibonacci.FibTemplate;

import java.util.HashMap;
import java.util.Map;

public class Fib extends FibTemplate {
    Map<Integer, Integer> cache = new HashMap<>();

    @Override
    public int fib(int n) {
        if (n < 0) {
            throw new RuntimeException("The params is invalid!");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result1 = 0;
        int result2 = 1;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            answer = (result1 + result2) % 1000000007;
            result1 = result2 % 1000000007;
            result2 = answer % 1000000007;
        }

        return answer;
    }

    public int fibCache(int n) {
        if (n < 0) {
            throw new RuntimeException("The params is invalid!");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        } else {
            int result = (fib(n - 1) + fib(n - 2)) % 1000000007;
            cache.put(n, result);
            return result;
        }
    }


    public int fibOvertime(int n) {
        if (n < 0) {
            throw new RuntimeException("The params is invalid!");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) % 1000000007 + fib(n - 2) % 1000000007;
    }
}
