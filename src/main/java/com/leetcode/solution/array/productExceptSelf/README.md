## 总结

https://leetcode.cn/problems/product-of-array-except-self/

```java
class Solution {
    // 问题1：什么类型数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否排序 => 不 care
    // 问题4：如何输出 => 返回数组
    // 问题5：函数定义
    // 问题6：检查输入参数
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 思路1 Brute Force：两层 for loop，都从 0 -> len, 如果 i == j skip. 时间复杂度 O(n^2) 空间复杂度 O(n)
        // 优化 => DUP => Duplicate
        // 思路2 数组前缀积：result[i] = nums[0] -> nums[i - 1] * nums[i + 1] -> nums[length - 1]
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int[] leftPrefixMultiple = new int[nums.length];
        int[] rightPrefixMultiple = new int[nums.length];
        leftPrefixMultiple[0] = 1;
        rightPrefixMultiple[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftPrefixMultiple[i] = leftPrefixMultiple[i - 1] * nums[i - 1];
            rightPrefixMultiple[nums.length - 1 - i] = rightPrefixMultiple[nums.length - i] * nums[nums.length - i];
        }


        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftPrefixMultiple[i] * rightPrefixMultiple[i];
        }

        return result;
    }
}
```

| 问题行数    | 错误点            | 正确写法           | 错误原因                   |
|---------|----------------|----------------|------------------------|
| 22      | for (int i = 0 | for (int i = 1 | 初始位置没有界定清楚，边界问题        |
| 23 - 24 | -              | -              | 没有想清楚，应该带入特殊值，之后从特殊到一般 |

### 优化空间

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // 优化空间 => 
        //   1. result 代替 leftPrefixMultiple
        //   2. factor 代替 rightPrefixMultiple
        // 第i个结果 answer[i] == answer[i] * factor
        // nums   =>  1  2  3  4
        // answer =>  1  1  2  6
        // factor = 1
        // i = 3
        // answer =>  1  1  2  6*1
        // factor = 1 * 4 = 4
        // i = 2 
        // answer =>  1  1  2*4 6
        // factor = 4 * 3 = 12
        // i = 1
        // answer =>  1 1*12 8  6
        // factor = 12 * 2 = 24
        // i = 0
        // answer =>  24 12 8  6
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int factor = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * factor;
            factor *= nums[i];
        }

        return answer;
    }
}
```
