package com.leetcode.solution.array.twoSum.first;

import com.leetcode.solution.array.twoSum.TwoSumTemplate;

import java.util.Arrays;

public class TwoSum extends TwoSumTemplate {
    public int[] twoSumForBruteForce(int[] nums, int target) {
        // 时间复杂度：O(n ^ 2)
        // 空间复杂度：O(1)
        if (nums.length <= 1) {
            return new int[2];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int currentNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (currentNum + nums[j] == target) {
                    if (currentNum < nums[j]) {
                        return new int[]{currentNum, nums[j]};
                    }
                    return new int[]{nums[j], currentNum};
                }
            }
        }
        return new int[2];
    }

    public int[] twoSum(int[] nums, int target) {
        // 1. 排序 => O(nlogn)
        // 2. 双指针 => O(n)
        // 时间复杂度：O(nlogn)
        // 空间复杂度：O(1)
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                if (nums[left] < nums[right]) {
                    return new int[]{nums[left] + nums[right]};
                }
                return new int[]{nums[right] + nums[left]};
            }
            if (nums[left] + nums[right] < target) {
                left++;
            }
            if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return null;
    }
}
