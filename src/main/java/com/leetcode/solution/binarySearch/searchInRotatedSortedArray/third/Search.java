package com.leetcode.solution.binarySearch.searchInRotatedSortedArray.third;

import com.leetcode.solution.binarySearch.searchInRotatedSortedArray.SearchTemplate;

public class Search extends SearchTemplate {
    @Override
    public int search(int[] nums, int target) {
        // 思路：start < end => 未旋转 => 和旋转可以一样的逻辑
        // 		start > end => 旋转 => 比较 start mid end，看 target 在哪段，舍弃另一段
        //      			mid 在 下部 => mid <= target <= end : start = mid => else end = mid
        //  				mid 在 上部 => start <= target <= mid : end = mid => else start = mid
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                // mid 在下部
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                // mid 在上部 或未旋转
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
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
