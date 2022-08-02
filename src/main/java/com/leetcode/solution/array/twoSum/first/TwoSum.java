package com.leetcode.solution.array.twoSum.first;

import java.util.Arrays;

/**
 * 给定一个整数数组（无重复元素）和一个目标值，找出数组中和为目标值的两个数。
 * 按照从小到大的顺序输出结果对
 * 可以假设每个输入只对应一种答案
 * Input: numbers = {2, 7, 11, 15}, target = 9
 * Output: {2, 7}
 */

public class TwoSum {

    public static int[] twoSumForBruteForce(int[] nums, int target) {
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

    public static int[] twoSum(int[] nums, int target) {
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
