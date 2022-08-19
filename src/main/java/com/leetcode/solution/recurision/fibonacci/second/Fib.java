package com.leetcode.solution.recurision.fibonacci.second;

import com.leetcode.solution.recurision.fibonacci.FibTemplate;

import java.util.HashMap;
import java.util.Map;

public class Fib extends FibTemplate {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int fibWithCache(int n) {
        // 思路：使用 map 进行缓存
        if (n < 0) {
            throw new IllegalArgumentException("The n is invalid!");
        }
        if (n == 0 || n == 1) {
            return n;
        }

        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = (fib(n - 1) + fib(n - 2)) % 1000000007;
        cache.put(n, result);
        return result;
    }

    public int fibWithArray(int n) {
        // 思路：滚动数组
        if (n < 0) {
            throw new IllegalArgumentException("The n is invalid");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }

    @Override
    public int fib(int n) {
        // 思路：滚动数组
        if (n < 0) {
            throw new IllegalArgumentException("The n is invalid");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result0 = 0;
        int result1 = 1;
        int answer;
        for (int i = 2; i <= n; i++) {
            answer = (result0 + result1) % 1000000007;
            result0 = result1;
            result1 = answer;
        }
        return result1;
    }
}
