package com.leetcode.solution.dynamicProgramming.maximumProductSubarray.second;

import com.leetcode.solution.dynamicProgramming.maximumProductSubarray.MaxProductTemplate;

public class MaxProduct extends MaxProductTemplate {
    @Override
    public int maxProduct(int[] nums) {
        // state => f(n) 表示以 nums[n] 结尾的最大子数组积
        //      有正负两个数组 => prevMaxValue + prevMinValue
        // status function => f(n) =
        //                      nums[i] < 0 => nums[i] * 正数(负值) + nums[i] * 负数(正值) => 更新最大值和最小值
        //                      nums[i] > 0 => nums[i] * 正数(正值) + nums[i] * 负数(负值) => 更新最大值和最小值
        // case: 2, 3, -2,  2,  3,  -2, -100
        //       2  6   1   2   6  144  1200
        //             -12 -24 -72 -12
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevMaxValue = nums[0];
        int prevMinValue = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                prevMaxValue = prevMaxValue > 0 ? prevMaxValue * nums[i] : nums[i];
                prevMinValue = prevMinValue < 0 ? prevMinValue * nums[i] : nums[i];
            } else {
                // nums[i] <= 0
                int temp = prevMaxValue;
                prevMaxValue = prevMinValue < 0 ? prevMinValue * nums[i] : nums[i];
                prevMinValue = temp > 0 ? temp * nums[i] : nums[i];
            }
            max = Math.max(max, prevMaxValue);
        }

        return max;
    }
}
