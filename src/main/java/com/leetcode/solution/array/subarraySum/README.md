## 总结

https://leetcode.cn/problems/subarray-sum-equals-k/

```java
class Solution {
    // 问题1：什么类型的数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 无序
    // 问题4：如何输出 => 输出连续子数组个数
    // 问题5：函数定义
    // 问题6：检查输入参数
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 思路1 Brute Fore：两层 for loop，时间复杂度O(n^2)，空间复杂度：O(1)
        // 优化 => DUP => Duplicate => 第二层的累加重复了
        // 思路2：数组前缀和
        // 时间复杂度O(n^2)
        // 空间复杂度：O(n)
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // interval[i, j] = prefixSum[j + 1] - prefixSum[i]
                if (prefixSum[j + 1] - prefixSum[i] == k) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
```

| 问题行数 | 错误点                                  | 正确写法                       | 错误原因                                  |
|------|--------------------------------------|----------------------------|---------------------------------------|
| 25   | int j = i + 1; j < prefixSum.length; | int j = i; j < nums.length | 边界条件没考虑好 => interval中的i和j都是相对于 nums 的 |
