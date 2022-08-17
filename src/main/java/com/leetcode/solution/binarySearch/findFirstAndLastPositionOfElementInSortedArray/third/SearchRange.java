package com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.third;

import com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.SearchRangeTemplate;

public class SearchRange extends SearchRangeTemplate {
    @Override
    public int[] searchRange(int[] nums, int target) {
        // 思路：两次二分查找，mid == target => end = mid => 找左侧
        // 				    mid == target => start = mid => 找右侧
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == nums[start]) {
            result[0] = start;
        } else if (target == nums[end]) {
            result[0] = end;
        } else {
            return result;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == nums[start]) {
            result[1] = start;
        }

        if (target == nums[end]) {
            result[1] = end;
        }

        return result;
    }
}
