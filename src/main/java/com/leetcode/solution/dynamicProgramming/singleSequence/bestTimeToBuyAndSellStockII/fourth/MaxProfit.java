package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
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
}
