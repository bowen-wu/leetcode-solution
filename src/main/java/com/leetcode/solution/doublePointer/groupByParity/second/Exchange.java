package com.leetcode.solution.doublePointer.groupByParity.second;

import com.leetcode.solution.doublePointer.groupByParity.ExchangeTemplate;

public class Exchange extends ExchangeTemplate {
    @Override
    public int[] exchange(int[] nums) {
        // Ideas: three pointer
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                result[end--] = nums[i];
            } else {
                result[start++] = nums[i];
            }
        }
        return result;
    }
}
