## 零钱兑换

<https://leetcode.cn/problems/coin-change/>

### 思路

1. 完全背包问题
2. state => dp[i][j] 表示前i个硬币总金额为j的最少硬币数量
3. statue function => dp[i][j] = Math.min(dp[i - 1][j - k * coins[i - 1]] + k), 其中 k * coins[i - 1] <= j 
4. condition => dp[0][0] = 0  dp[0][j] = Integer.MAX_VALUE  dp[i][0] = 0
5. solution => dp[len][amount]

#### 优化

1. 空间优化 => 一维数组 => dp[j] = dp[j - coins[i]] + 1
2. max = amount + 1 => 最小硬币是1

