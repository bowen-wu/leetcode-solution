package com.leetcode.solution.recurision.fibonacci.third;

import com.leetcode.solution.recurision.fibonacci.FibTemplate;

import java.util.HashMap;
import java.util.Map;

public class Fib extends FibTemplate {

    private Map<Integer, Integer> cache = new HashMap<>();

    @Override
    public int fib(int n) {
        // 思路：滚动数组
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result1 = 0;
        int result2 = 1;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            answer = (result1 + result2) % 1000000007;
            result1 = result2;
            result2 = answer;
        }
        return answer;
    }

    public int fibWithCache(int n) {
        // 思路：带缓存 cache map
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache.get(n) == null) {
            int value = (fib(n - 1) + fib(n - 2)) % 1000000007;
            cache.put(n, value);
            return value;
        }
        return cache.get(n);
    }
}
