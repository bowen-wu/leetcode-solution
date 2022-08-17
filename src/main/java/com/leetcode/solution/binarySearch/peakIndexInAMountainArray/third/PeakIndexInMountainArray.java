package com.leetcode.solution.binarySearch.peakIndexInAMountainArray.third;

import com.leetcode.solution.binarySearch.peakIndexInAMountainArray.PeakIndexInMountainArrayTemplate;

public class PeakIndexInMountainArray extends PeakIndexInMountainArrayTemplate {
    @Override
    public int peakIndexInMountainArray(int[] arr) {
        // 思路：二分查找 => 判断单调性 => mid 与 mid + 1 比较
        // mid < mid + 1 => 单调递增
        // mid > mid + 1 => 单调递减
        if (arr == null || arr.length < 3) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // 单调递增
                start = mid;
            } else {
                // case: 132 => end = 3
                end = mid;
            }
        }

        return end;
    }
}
