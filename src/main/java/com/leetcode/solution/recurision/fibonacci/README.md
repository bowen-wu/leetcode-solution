## 斐波那契数列

<https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/>

### 思路

### 总结

1. 答案要取余
2. 第三遍总结 => 答案要取余

```java
// 使用 map 做 cache
class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        // 思路：使用 map 进行缓存
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
}
```

1. 数组长度为 n + 1
2. 取余

```java
// 使用数组缓存
class Solution {
    public int fib(int n) {
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
}
```

```java
// 滚动数组 => 空间复杂度降低
class Solution {
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
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            answer = (result0 + result1) % 1000000007;
            result0 = result1;
            result1 = answer;
        }
        return result1;
    }
}
```
