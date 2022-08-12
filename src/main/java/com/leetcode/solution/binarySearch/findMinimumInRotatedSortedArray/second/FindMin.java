package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.second;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    // 思路：递增序列旋转。精髓 => 比较 start end mid
    //      1. end > start => 未旋转 => 直接返回 start
    // 		2. 旋转过 =>
    // 				start < mid => start = mid
    //   			end = mid
    @Override
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        if (nums[start] < nums[end]) {
            // 未旋转
            return nums[start];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}

