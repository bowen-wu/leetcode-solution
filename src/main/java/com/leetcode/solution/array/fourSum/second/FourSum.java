package com.leetcode.solution.array.fourSum.second;

import com.leetcode.solution.array.fourSum.FourSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum extends FourSumTemplate {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路：将四数之和固定一个数组，简化为三数之和，之后再固定一个数组，简化为两数之和
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        if (nums[0] > 0 && target < 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            // 如果当前值和上一个值重复，则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 如果当前值和上一个值重复，则跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 如果当前值和上一个值重复，则跳过
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }

                    // 如果当前值和后一个值相等，则跳过
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                    }

                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    }

                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
