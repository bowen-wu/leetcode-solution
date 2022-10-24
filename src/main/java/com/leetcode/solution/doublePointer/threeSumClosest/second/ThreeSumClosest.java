package com.leetcode.solution.doublePointer.threeSumClosest.second;

import com.leetcode.solution.doublePointer.threeSumClosest.ThreeSumClosestTemplate;

import java.util.Arrays;

public class ThreeSumClosest extends ThreeSumClosestTemplate {
    @Override
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                }
            }
        }

        return result;
    }
}
