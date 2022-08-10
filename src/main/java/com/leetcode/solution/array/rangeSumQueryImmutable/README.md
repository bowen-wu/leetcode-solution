## 区域和检索 - 数组不可变

<https://leetcode.cn/problems/range-sum-query-immutable/>

### 总结

```java
class NumArray {
    // 思路：数组前缀和 => interval[i, j] = prefixSum[j + 1] - prefixSum[i]
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        // O(n) + O(n)
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("The param of nums is invalid!");
        }
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // O(1)
        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

| 问题行数 | 错误点       | 正确写法         | 错误原因 |
|------|-----------|--------------|------|
| 12   | prefix[i] | prefixSum[i] | 笔误   |
