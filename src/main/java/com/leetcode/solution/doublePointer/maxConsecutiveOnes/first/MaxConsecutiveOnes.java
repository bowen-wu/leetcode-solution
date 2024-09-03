package com.leetcode.solution.doublePointer.maxConsecutiveOnes.first;

import com.leetcode.solution.doublePointer.maxConsecutiveOnes.MaxConsecutiveOnesTemplate;

public class MaxConsecutiveOnes extends MaxConsecutiveOnesTemplate {
    @Override
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int result = 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }

        return Math.max(result, count);
    }
}
