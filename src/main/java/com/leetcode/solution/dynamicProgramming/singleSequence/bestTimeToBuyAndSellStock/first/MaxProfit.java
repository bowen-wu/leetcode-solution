package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentValue = prices[i];
            if (currentValue - min > result) {
                result = currentValue - min;
            }
            if (currentValue < min) {
                min = currentValue;
            }
        }

        return Math.max(result, 0);
    }
}
