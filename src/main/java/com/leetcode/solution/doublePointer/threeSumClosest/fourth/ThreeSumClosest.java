package com.leetcode.solution.doublePointer.threeSumClosest.fourth;

import com.leetcode.solution.doublePointer.threeSumClosest.ThreeSumClosestTemplate;

import java.util.Arrays;

public class ThreeSumClosest extends ThreeSumClosestTemplate {
    @Override
    public int threeSumClosest(int[] nums, int target) {
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
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
