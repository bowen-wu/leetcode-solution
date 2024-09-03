package com.leetcode.solution.doublePointer.maxConsecutiveOnesIII.first;

import com.leetcode.solution.doublePointer.maxConsecutiveOnesIII.MaxConsecutiveOnesIIITemplate;

public class MaxConsecutiveOnesIII extends MaxConsecutiveOnesIIITemplate {
    @Override
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int result = 0;
        int j = 0;
        int changed = 0;

        for (int i = 0; i < len; i++) {
            while (j < len) {
                if (nums[j] == 1 || changed < k) {
                    if (nums[j] != 1) {
                        changed++;
                    }

                    j++;
                } else {
                    break;
                }
            }

            result = Math.max(result, j - i);
            if (nums[i] != 1) {
                changed--;
            }
        }

        return result;
    }
}
