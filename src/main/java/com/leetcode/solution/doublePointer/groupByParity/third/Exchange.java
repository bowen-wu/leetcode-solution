package com.leetcode.solution.doublePointer.groupByParity.third;

import com.leetcode.solution.doublePointer.groupByParity.ExchangeTemplate;

public class Exchange extends ExchangeTemplate {
    @Override
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len];
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                result[right--] = nums[i];
            } else {
                result[left++] = nums[i];
            }
        }
        return result;
    }
}

