package com.leetcode.solution.array.threeSum.third;

import com.leetcode.solution.array.threeSum.ThreeSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum extends ThreeSumTemplate {
    @Override
    public int[] threeSum(int[] nums, int target) {
        // 思路
        // 1. Brute Force => 三层循环 O(n ^ 3)
        // 2. 排序 + 双指针 => 先排序，第一个 for loop 确定第一个数字，之后双指针。O(n^2)
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > target) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] == target) {
                    return new int[]{nums[i], nums[start], nums[end]};
                } else {
                    start++;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 思路
        // 1. Brute Force => 三层循环 O(n ^ 3)
        // 2. 排序 + 双指针 => 先排序，第一个 for loop 确定第一个数字，之后双指针。O(n^2)
        if (nums == null || nums.length == 0) {
            return null;
        }
        int target = 0;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 不能有重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // 不能有重复元素
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] > target) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] == target) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                } else {
                    start++;
                }
            }
        }

        return result;
    }
}
