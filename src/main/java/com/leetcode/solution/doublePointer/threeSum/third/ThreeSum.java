package com.leetcode.solution.doublePointer.threeSum.third;

import com.leetcode.solution.doublePointer.threeSum.ThreeSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum extends ThreeSumTemplate {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        // has repeated
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
