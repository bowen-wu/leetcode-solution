## 买卖股票的最佳时机 II

<https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/>

### 思路

1. 贪心 => 获取所有上升段的差值
2. DP =>

### 总结

1. 思路
    - 贪心，获取所有上升段的差值
    - DP

```java
class Solution {
    public int maxProfitGreedy(int[] prices) {
        // 贪心
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }

    public int maxProfitDp(int[] prices) {
        // DP
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
        }

        return Math.max(dp[(len - 1) % 2][0], dp[(len - 1) % 2][1]);
    }
}
```


