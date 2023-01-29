package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    public int maxProfit(int[] prices) {
        // Idea: 找到最小值 & 比较当前值和最小值的差
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
            result = Math.max(result, prices[i] - min);
        }

        return result;
    }
}
