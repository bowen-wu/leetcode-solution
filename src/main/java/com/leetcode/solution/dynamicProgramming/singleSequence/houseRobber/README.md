## 打家劫舍

<https://leetcode.cn/problems/house-robber/>

### 思路

1. State => f(n) 代表在 n 家时偷窃到的最高金额
    1. 偷第 n 家 => f(n - 2) + 第 n 家的金额
    2. 不偷第 n 家 => f(n - 1)
2. Function => f(n) = Math.max(f(n - 1), f(n - 2) + 第 n 家的金额)
3. Condition
4. Solution => 求解 f(n)

#### 注意

1. memo[0] = 0; & memo[1] = nums[0]
2. 可以移动到 nums.length
3. 第 i 家的金额 => nums[i - 1]

### 总结

1. 状态转移方程 => f(n) = Math.max(f(n - 1), f(n - 2) + 第 n 家的金额(nums[n - 1]))

| 问题行数 | 错误点                                                                     | 正确写法                                                                        | 错误原因                      |
|------|-------------------------------------------------------------------------|-----------------------------------------------------------------------------|---------------------------|
| 18   | memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i]); | memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]); | 思路                        |
| 18   | memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i]); | memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]); | 第i家中的 i == nums[i - 1]。细节 |
| 20   | return memo[nums.length]                                                | return memo[nums.length % 2]                                                | 大意                        |

```java
class Solution {
    public int rob(int[] nums) {
        // state => f(n) 表示偷窃到第n家时的偷窃总额
        // status function => f(n) = Math.max(偷第n - 1家, 不偷第n - 1家) = Math.max(nums[n - 1] + f(n - 2), f(n - 1))
        // condition => x
        // solution => 求 f(nums.length)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // case: [1, 2, 3, 1]
        //       [0, 1, max(1, 2)]
        //       [0, 1, 2, max(1 + 3, 2)]
        //       [0, 1, 2, 4, max(2 + 1, 4)]
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            memo[i % 2] = Math.max(nums[i - 1] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }
        return memo[nums.length % 2];
    }
}
```
