package com.leetcode.solution.doublePointer.threeSum.fourth;

import com.leetcode.solution.doublePointer.threeSum.ThreeSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum extends ThreeSumTemplate {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        // check input
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                // skip repeat
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum <= 0) {
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                } else {
                    right--;
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
