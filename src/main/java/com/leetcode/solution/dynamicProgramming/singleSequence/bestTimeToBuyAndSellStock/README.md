## 买卖股票的最佳时机

<https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/>

### 思路

1. 贪心
2. 遍历的时候更新最小值和利润

### 总结

1. 思路，遍历的时候更新最小值和利润

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 没有思路，不会贪心
        // 贪心 => 找到最小值
        if (prices == null || prices.length == 0) {
            return 0;
        }


        int result = 0;
        int min = prices[0];
        int len = prices.length;

        for (int i = 1; i < len; i++) {
            if (prices[i] - min > result) {
                result = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return result;
    }
}
```

