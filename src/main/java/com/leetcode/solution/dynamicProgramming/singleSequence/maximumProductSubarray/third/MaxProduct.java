package com.leetcode.solution.dynamicProgramming.singleSequence.maximumProductSubarray.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.maximumProductSubarray.MaxProductTemplate;

public class MaxProduct extends MaxProductTemplate {
    @Override
    public int maxProduct(int[] nums) {
        // state => f(n) 代表以 nums[n] 为结尾的最大值和最小值
        // status function =>
        //          nums[i] > 0 =>
        //                         maxValue = (prevMaxValue > 0 ? prevMaxValue : 1) * nums[i]
        //                         minValue = (prevMinValue < 0 ? prevMinValue : 1) * nums[i]
        //          nums[i] < 0 =>
        //                         maxValue = (prevMinValue < 0 ? prevMinValue : 1) * nums[i]
        //                         minValue = (prevMaxValue > 0 ? prevMaxValue : 1) * nums[i]
        // condition => maxValue = nums[0] minValue = nums[0]
        // solution => get max(positive[n]) n == 0 -> nums.length
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int maxValue = nums[0];
        int minValue = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                maxValue = (maxValue > 0 ? maxValue : 1) * nums[i];
                minValue = (minValue < 0 ? minValue : 1) * nums[i];
            } else {
                int temp = maxValue;
                maxValue = (minValue < 0 ? minValue : 1) * nums[i];
                minValue = (temp > 0 ? temp : 1) * nums[i];
            }
            max = Math.max(max, maxValue);
        }

        return max;
    }
}
