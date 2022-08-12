package com.leetcode.solution.binarySearch.searchInRotatedSortedArray.second;

import com.leetcode.solution.binarySearch.searchInRotatedSortedArray.SearchTemplate;

public class Search extends SearchTemplate {
    // 思路：二分查找。比较 start mid end 的值
    // 		1. mid > start
    // 			start < target && target < mid => end = mid
    // 			else => start = mid
    //      2. mid < end
    // 			mid < target && target < end => start = mid
    // 			else => end = mid
    @Override
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // mid <= end
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
