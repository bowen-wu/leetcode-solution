package com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.second;

import com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.SearchRangeTemplate;

import java.util.Arrays;

public class SearchRange extends SearchRangeTemplate {
    // 思路：两次二分查找，第一次二分查找确定 result[0]，第二次二分查找确定 result[1] O(logn)
    // 第一次二分查找相等时，end = mid
    // 第二次二分查找相等时，start = mid
    @Override
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
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
