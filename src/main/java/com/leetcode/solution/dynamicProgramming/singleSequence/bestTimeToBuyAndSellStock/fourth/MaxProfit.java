package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // 贪心
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int min = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }

        return result;
    }
}
