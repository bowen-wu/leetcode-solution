package com.leetcode.solution.binarySearch.binarySearch.first;

import com.leetcode.solution.binarySearch.binarySearch.SearchTemplate;

public class Search extends SearchTemplate {
    @Override
    public int search(int[] nums, int target) {
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

        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        return -1;
    }
}
