## 总结

https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/

```java
class Solution {
    // 问题1：什么类型的数组 => 正整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 不 care
    // 问题4：如何输出 => int
    // 问题5：函数定义
    // 问题6：检查输入参数
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // 思路1 暴力解：两层 for 循环。子数组长度 len，len -> arr.length，len += 2，
        //               从 index = 0 开始，i -> arr.length - len
        //               时间复杂度：O(n^2) 空间复杂度：O(1)
        // 优化思路 => DUP => Duplitcated => 第二层 for 循环实际就是 interval[i, j]
        // 思路2：数组前缀和
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n)
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int result = prefixSum[arr.length];
        for (int len = 3; len <= arr.length; len += 2) {
            for (int start = 0; start + len <= arr.length; start++) {
                // interval[i, j] = prefixSum[j + 1] - prefixSum[i]
                result += prefixSum[start + len] - prefixSum[start];
            }
        }

        return result;
    }
}
```

| 问题行数 | 错误点                      | 正确写法                      | 错误原因       |
|------|--------------------------|---------------------------|------------|
| 29   | prefix[start]            | prefixSum[start]          | 笔误         |
| 27   | start + len < arr.length | start + len <= arr.length | 边界条件没有考虑清楚 |
