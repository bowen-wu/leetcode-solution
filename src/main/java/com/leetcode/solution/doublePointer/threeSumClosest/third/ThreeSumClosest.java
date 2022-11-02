package com.leetcode.solution.doublePointer.threeSumClosest.third;

import com.leetcode.solution.doublePointer.threeSumClosest.ThreeSumClosestTemplate;

import java.util.Arrays;

public class ThreeSumClosest extends ThreeSumClosestTemplate {
    @Override
    public int threeSumClosest(int[] nums, int target) {
        // check input
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    // update
                    result = sum;
                }
                if (sum < target) {
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
