package com.leetcode.solution.array.fourSum.third;

import com.leetcode.solution.array.fourSum.FourSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum extends FourSumTemplate {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路：排序，确定前两个值，之后使用双指针。O(n^3)
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start - 1] == nums[start]) {
                        start++;
                        continue;
                    }
                    if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    if (nums[i] + 0.0 + nums[j] + 0.0 + nums[start] + 0.0 + nums[end] < target) {
                        start++;
                    } else if (nums[i] + 0.0 + nums[j] + 0.0 + nums[start] + 0.0 + nums[end] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                    } else {
                        // nums[i] + nums[j] + nums[start] + nums[end] > target
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
