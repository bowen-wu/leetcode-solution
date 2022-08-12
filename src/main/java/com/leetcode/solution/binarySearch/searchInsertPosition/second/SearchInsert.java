package com.leetcode.solution.binarySearch.searchInsertPosition.second;

import com.leetcode.solution.binarySearch.searchInsertPosition.SearchInsertTemplate;

public class SearchInsert extends SearchInsertTemplate {
    // 思路：进行二分查找，得到 start 和 end
    // 	如果相等，就直接返回 start 或 end
    //  target < nums[start] => return start
    //  target < nums[end] => return end
    //  return end + 1 => target >= nums[start] && target >= nums[end]
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
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
        }

        if (nums[end] >= target) {
            return end;
        }

        return end + 1;
    }
}
