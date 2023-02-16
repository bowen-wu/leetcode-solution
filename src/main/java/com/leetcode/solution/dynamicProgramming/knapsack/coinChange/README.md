## 零钱兑换

<https://leetcode.cn/problems/coin-change/>

### 思路

1. 完全背包问题
2. state => dp[i][j] 表示前i个硬币总金额为j的最少硬币数量
3. statue function => dp[i][j] = Math.min(dp[i - 1][j - k * coins[i - 1]] + k), 其中 k * coins[i - 1] <= j
4. condition => dp[0][0] = 0 dp[0][j] = Integer.MAX_VALUE dp[i][0] = 0
5. solution => dp[len][amount]

#### 优化

1. 空间优化 => 一维数组 => dp[j] = dp[j - coins[i]] + 1 => 理解
    1. 加选
    2. 125 => 11
        1. 11 = dp[10] + 1 * 1
        2. 11 = dp[9] + 1 * 2
        3. 11 = dp[6] + 1 * 5
2. max = amount + 1 => 最小硬币是1

### 总结

1. 空间优化之后变为一维数组
2. 如果 dp 是二维数组，第一个数组的 length 应该是 len + 1。边界条件

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 完全背包
        // state => dp[j] 表示凑成金额j的最少硬币数
        // status function => dp[j] = Math.min(dp[j - coin] + 1)
        // condition => dp[0] = 0 
        // solution => dp[amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[j] = amount + 1;
            for (int coin : coins) {
                if (j >= coin && dp[j - coin] + 1 > 0) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

