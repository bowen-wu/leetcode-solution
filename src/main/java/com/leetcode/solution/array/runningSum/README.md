## 一维数组的动态和

<https://leetcode.cn/problems/running-sum-of-1d-array/>

### 总结

```java
class Solution {
    public int[] runningSum(int[] nums) {
        // 思路：数组前缀和 O(n) + O(n)
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }
}
```

| 问题行数 | 错误点           | 正确写法            | 错误原因 |
|------|---------------|-----------------|------|
| 8    | int prefixSum | int[] prefixSum | 笔误   |
