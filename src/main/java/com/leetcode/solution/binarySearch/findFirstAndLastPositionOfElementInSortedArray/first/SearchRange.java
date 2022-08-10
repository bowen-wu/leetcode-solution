package com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.first;

import com.leetcode.solution.binarySearch.findFirstAndLastPositionOfElementInSortedArray.SearchRangeTemplate;

public class SearchRange extends SearchRangeTemplate {
    @Override
    public int[] searchRange(int[] nums, int target) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];

        // 找左侧边界
        int leftStart = 0;
        int leftEnd = nums.length - 1;
        while (leftStart + 1 < leftEnd) {
            int mid = leftStart + (leftEnd - leftStart) / 2;
            if (target > nums[mid]) {
                leftStart = mid;
            } else {
                leftEnd = mid;
            }
        }

        if (target == nums[leftStart]) {
            result[0] = leftStart;
        } else if (target == nums[leftEnd]) {
            result[0] = leftEnd;
        } else {
            result[0] = result[1] = -1;
            return result;
        }

        // 找右侧边界
        int rightStart = 0;
        int rightEnd = nums.length - 1;
        while (rightStart + 1 < rightEnd) {
            int mid = rightStart + (rightEnd - rightStart) / 2;
            if (target >= nums[mid]) {
                rightStart = mid;
            } else {
                rightEnd = mid;
            }
        }

        // 此时一定能找到
        if (target == nums[rightStart]) {
            result[1] = rightStart;
        }
        if (target == nums[rightEnd]) {
            result[1] = rightEnd;
        }

        return result;
    }
}
