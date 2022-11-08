## 买卖股票的最佳时机 III

<https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/>

### 思路

1. state => dp[i][j][l] 表示第i天之后经历了j次交易手中持股状态为l的收益 => l = 0 | 1
2. status function => dp[i][j][l] => 卖出才算一笔交易
    1. 第i天交易了
        1. 买入 => dp[i][j][1] = dp[i - 1][j][0] - prices[i]
        2. 卖出 => dp[i][j][0] = dp[i - 1][j - 1][1] + prices[i]
    2. 第i天没有交易 => dp[i][j][0] = dp[i - 1][j][0] & dp[i][j][1] = dp[i - 1][j][1]
3. condition => i == 0 -> len & j == 0 -> 2
    1. dp[0][0][0] = 0
    2. dp[0][0][1] = -prices[0]
4. solution => get dp[prices.length][2][0]

#### 注意

1. 初始化需要好好考虑 => 三维问题，所以初始化需要把三维都考虑到
