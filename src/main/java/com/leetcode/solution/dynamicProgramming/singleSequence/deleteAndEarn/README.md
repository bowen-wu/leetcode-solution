## 删除并获得点

<https://leetcode.cn/problems/delete-and-earn/>

### 思路

1. 取一个数 num，那么数组中所有等于这个值的数字都会被取到
2. 所有等于 num - 1 和 num + 1 的数字都会被删除
3. 选择 num 前后都不能选择 => 价值数组
4. 价值数组 values => num 为下标，**num * 出现次数**为值的数组
5. 打家劫舍问题
    1. State => memo[i] 代表到第 i 家偷窃的金额
    2. Function => memo[i] = max(偷窃当前家，不偷窃当前家) => Math.max(memo[i - 1], memo[i - 2] + values[i])
    3. Condition =>
        1. memo[0] = value[0];
        2. memo[1] = value[1];

### 总结

| 问题行数 | 错误点                                     | 正确写法                                     | 错误原因 |
|------|-----------------------------------------|------------------------------------------|------|
| 29   | for (int i = 2; i < earn.length; i++) { | for (int i = 2; i <= earn.length; i++) { | 边界问题 |

```java
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 转化问题 => case: [2, 2, 3, 3, 3, 4]
        //  1. 找最大值 => O(n) => 4
        //  2. 创建数组 => [0, 0, 0, 0, 0]
        //  3. 遍历 => [0, 0, 4, 9, 4]
        //  4. 打家劫舍
        // state => f(n) 表示偷窃到第n家偷窃总额
        // status function => f(n) = Math.max(偷窃第n-1家, 偷窃第n家) = Math.max(f(n - 1), nums[n - 1] + f(n - 2))
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => 求 f(n)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] earn = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            earn[nums[i]] += nums[i];
        }

        int result = 0;
        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = earn[0];
        for (int i = 2; i <= earn.length; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], earn[i - 1] + memo[(i - 2) % 2]);
        }

        return memo[earn.length % 2];
    }
}
```
