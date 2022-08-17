package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.third;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    @Override
    public int findMin(int[] nums) {
        // 思路：start < end 未旋转
        // 		start > end 旋转 => 比较 start mid end 的值
        // 		 mid > start => start = mid => else end = mid
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                // mid 在上部
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
