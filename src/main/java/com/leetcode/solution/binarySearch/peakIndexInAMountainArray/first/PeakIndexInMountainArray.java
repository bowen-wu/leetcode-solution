package com.leetcode.solution.binarySearch.peakIndexInAMountainArray.first;

import com.leetcode.solution.binarySearch.peakIndexInAMountainArray.PeakIndexInMountainArrayTemplate;

public class PeakIndexInMountainArray extends PeakIndexInMountainArrayTemplate {
    @Override
    public int peakIndexInMountainArray(int[] arr) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // 单调递减
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public int peakIndexInMountainArrayTwo(int[] arr) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid - 1] < arr[mid]) {
                // 单调递增
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
