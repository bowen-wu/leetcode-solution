package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.second;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    // 思路：二分查找。如果 start < end，则未旋转，返回 start
    // 旋转 => 1. mid > start => start = mid
    //        2. mid < end => end = start
    //        3. start++ => end <= mid <= start  => start 有可能从最高点移动到最低点，此时要判断是否是单调递增
    @Override
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else if (nums[end] > nums[mid]) {
                end = mid;
            } else {
                start++;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
