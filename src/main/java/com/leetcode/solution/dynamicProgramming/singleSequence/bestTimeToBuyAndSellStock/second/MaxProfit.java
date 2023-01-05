package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStock.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
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
