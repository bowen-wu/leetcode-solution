package com.leetcode.solution.doublePointer.groupByParity.first;

import com.leetcode.solution.doublePointer.groupByParity.ExchangeTemplate;

public class Exchange extends ExchangeTemplate {
    @Override
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len];
        int start = 0;
        int end = len - 1;

        for (int num : nums) {
            if (num % 2 != 0) {
                result[start++] = num;
            } else {
                result[end--] = num;
            }
        }
        return result;
    }
}
