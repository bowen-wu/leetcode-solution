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

### 总结

1. solution 直接返回 ` dp[len - 1][2][0] `，不需要再进行比较
2. `dp[i][0][1] = Math.max(-prices[i - 1], -prices[i]);`此处需要使用比较方法

```java
class Solution {
    public int maxProfit(int[] prices) {
        // state => dp[i][j][k] 第i天经过j笔交易持股状态k的情况下的余额
        // status function => 
        //                  dp[i][j][0] = Math.max(dp[i - 1][j][0], j == 0 ? 0 : dp[i - 1][j - 1][1] + prices[i]);
        //                  dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
        // condition => dp[0][0][0] = 0          dp[0][1][0] = 0
        //              dp[0][0][1] = -prices[0] dp[0][1][1] = 0
        // solution => Math.max(dp[len - 1][j][0]) j = 0, 1, 2
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], j == 0 ? 0 : (dp[i - 1][j - 1][1] + prices[i]));
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[len - 1][2][0];
    }

    public int maxProfitWithScrollArray(int[] prices) {
        // 滚动数组优化
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[2][3][2];
        for (int j = 0; j < 3; j++) {
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            dp[i % 2][0][1] = Math.max(dp[(i - 1) % 2][0][1], -prices[i]);

            for (int j = 1; j < 3; j++) {
                dp[i % 2][j][0] = Math.max(dp[(i - 1) % 2][j][0], dp[(i - 1) % 2][j - 1][1] + prices[i]);
                dp[i % 2][j][1] = Math.max(dp[(i - 1) % 2][j][1], dp[(i - 1) % 2][j][0] - prices[i]);
            }
        }

        return dp[(len - 1) % 2][2][0];
    }
}
```
