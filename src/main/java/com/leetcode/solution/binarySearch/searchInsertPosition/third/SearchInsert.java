package com.leetcode.solution.binarySearch.searchInsertPosition.third;

import com.leetcode.solution.binarySearch.searchInsertPosition.SearchInsertTemplate;

public class SearchInsert extends SearchInsertTemplate {
    @Override
    public int searchInsert(int[] nums, int target) {
        // 思路：二分查找
        // 找到了直接返回
        // target < start => start
        // target > start && target < end => end
        // target > end => end + 1
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target <= nums[start]) {
            return start;
        }

        if (target <= nums[end]) {
            return end;
        }

        return end + 1;
    }
}
