package com.leetcode.solution.binarySearch.searchInsertPosition.first;

import com.leetcode.solution.binarySearch.searchInsertPosition.SearchInsertTemplate;

public class SearchInsert extends SearchInsertTemplate {
    @Override
    public int searchInsert(int[] nums, int target) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (nums == null || nums.length == 0) {
            return -1;
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

        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
