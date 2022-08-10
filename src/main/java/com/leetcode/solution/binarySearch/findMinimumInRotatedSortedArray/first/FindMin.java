package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.first;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArray.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    @Override
    public int findMin(int[] nums) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
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
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
