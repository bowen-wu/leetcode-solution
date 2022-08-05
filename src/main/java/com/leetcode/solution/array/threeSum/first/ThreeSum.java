package com.leetcode.solution.array.threeSum.first;

import com.leetcode.solution.array.threeSum.ThreeSumTemplate;

import java.util.Arrays;

public class ThreeSum extends ThreeSumTemplate {
    public int[] threeSumBruteForce(int[] nums, int target) {
        // 暴力
        // 时间复杂度：O(n ^ 3)
        // 空间复杂度：O(1)
        if (nums.length <= 2) {
            return new int[3];
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        return new int[]{nums[i], nums[j], nums[k]};
                    }
                }
            }
        }
        return new int[3];
    }

    public int[] threeSum(int[] nums, int target) {
        // 1. 排序：O(nlogn)
        // 2. for loop + 双指针 => O(n^2)
        // threeSum 转化为 twoSum
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        if (nums.length <= 2) {
            return null;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (first + nums[left] + nums[right] == target) {
                    return new int[]{first, nums[left], nums[right]};
                }
                if (first + nums[left] + nums[right] > target) {
                    right--;
                }
                if (first + nums[left] + nums[right] < target) {
                    left++;
                }
            }
        }
        return null;
    }
}
