## 最佳买卖股票时机含冷冻期

<https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/>

### 思路

1. 冷冻期中的持有股票不能是前一天买的，一定是前两天买的 => ` dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]); `

### 总结

1. 与之前的两天有关，滚动数组长度应该是 3
2. 注意 length == 1

| 问题行数 | 错误点                                                                          | 正确写法                                                                         | 错误原因    |
|------|------------------------------------------------------------------------------|------------------------------------------------------------------------------|---------|
| 20   | -                                                                            | -                                                                            | 滚动数组要取模 |
| 20   | dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] - prices[i]); | dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]); | 细节      |


```java
class Solution {
    public int maxProfit(int[] prices) {
        // state => dp[i][j] 表示第i天持股状态为j的情况下的余额
        // status function => 
        //                  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        //                  dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        // condition => dp[0][0] = 0  dp[0][1] = -prices[0]
        //              dp[1][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i])  
        //              dp[1][1] = Math.max(dp[i - 1][1], -prices[1]);
        // solution => dp[len - 1][0]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[3][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], i == 1 ? -prices[1] : dp[(i - 2) % 3][0] - prices[i]);
        }

        return dp[(len - 1) % 3][0];
    }
}
```
