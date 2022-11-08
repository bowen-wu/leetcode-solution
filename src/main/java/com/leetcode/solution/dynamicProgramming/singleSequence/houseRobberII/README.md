## 打家劫舍 II

<https://leetcode.cn/problems/house-robber-ii/>

### 思路

1. 房屋成环 => 偷窃第一家就不能偷窃最后一家，偷窃第二家，可能会偷窃最后一家
2. 分成两个 打家劫舍 问题
    1. State => memo[i] 代表到达第 i 家偷窃的金额
    2. 偷窃第一家 => Function => memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1]) => 如果是最后一家则不偷窃
    3. 偷窃第二家 => Function => memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1])

### 总结

1. 思路：分成两个打家劫舍问题 => 偷窃第一家到倒数第二家 + 偷窃第二家到最后一家

```java
class Solution {
    public int rob(int[] nums) {
        // state => f(n) 表示偷窃到第n家时的偷窃总额
        // status function => f(n) = Math.max(偷窃到前一家的总额, 偷窃第n家 + 偷窃到第 n - 2 家的总额) = Math.max(偷n - 1家, 偷第n家(不能偷第一家))
        // 如果是奇数，则偷窃到最后一家时 - nums[0]
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => 求 f(nums.length)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        // corn case
        if (len == 1) {
            return nums[0];
        }

        // 偷第一家 => 不偷最后一家
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i < len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], nums[i - 1] + memo[(i - 2) % 2]);
        }
        int result = memo[(len - 1) % 2];


        // 偷第二家
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], nums[i - 1] + memo[(i - 2) % 2]);
        }

        return Math.max(result, memo[len % 2]);
    }
}
```
