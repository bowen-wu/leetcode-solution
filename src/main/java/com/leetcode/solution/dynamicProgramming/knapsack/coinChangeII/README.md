## 零钱兑换 II

<https://leetcode.cn/problems/coin-change-ii/>

### 思路

1. 完全背包问题
2. state => dp[i] 表示凑成金额i的方案总数
3. status function => dp[i] = $\sum_0^len$(dp[i - coins[j]])
4. condition => dp[0] = 1
5. solution => dp[amount]
6. 需要先遍历硬币，避免重复
7. 如果先遍历金额，会重复
