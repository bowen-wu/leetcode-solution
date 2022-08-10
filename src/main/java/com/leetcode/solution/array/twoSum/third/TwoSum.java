package com.leetcode.solution.array.twoSum.third;

import com.leetcode.solution.array.twoSum.TwoSumTemplate;

import java.util.Arrays;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] nums, int target) {
        // 思路
        // 排序 + 双指针 => O(nlogn)
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else {
                left++;
            }
        }

        return null;
    }
}
