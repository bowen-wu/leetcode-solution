package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.third;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    @Override
    public int findMin(int[] nums) {
        // 思路：start < end => 未旋转
        // 		start > end => 旋转
        // 			start < mid => start = mid
        //			mid < end => end = mid
        //			相等的情况 => start++ => 需要查看 start 是否移到了下部
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            if (nums[start] < nums[mid]) {
                start = mid;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start++;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
