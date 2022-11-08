package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfitDp(int[] prices) {
        return 0;
    }

    @Override
    public int maxProfitGreedy(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] - prices[i - 1];
            if (gap > 0) {
                result += gap;
            }
        }

        return result;
    }
}
