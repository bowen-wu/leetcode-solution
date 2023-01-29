package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfitGreedy(int[] prices) {
        // Ideas: 获取每一段的差值
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            int gap = prices[i] - prices[i - 1];
            if (gap > 0) {
                result += gap;
            }
        }

        return result;
    }

    @Override
    public int maxProfitDp(int[] prices) {
        return 0;
    }
}
