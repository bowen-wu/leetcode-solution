package com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.first;

import com.leetcode.solution.binarySearch.findMinimumInRotatedSortedArrayII.FindMinTemplate;

public class FindMin extends FindMinTemplate {
    @Override
    public int findMin(int[] nums) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        // nums[start] >= nums[end]
        while (start + 1 < end) {
            // start++ 之后，有可能落入同一个单调递增区间内 => 判断是否无旋转
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                start++;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
