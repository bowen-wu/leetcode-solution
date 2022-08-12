package com.leetcode.solution.binarySearch.peakIndexInAMountainArray.second;

import com.leetcode.solution.binarySearch.peakIndexInAMountainArray.PeakIndexInMountainArrayTemplate;

public class PeakIndexInMountainArray extends PeakIndexInMountainArrayTemplate {
    // 思路：二分查找。判断 mid 是在单调递增还是单调递减区间上
    //  mid < mid + 1 => 单调递增 => start = mid
    //  mid > mid + 1 => 单调递减 => end = mid
    @Override
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 必定进入循环。case：132 start = 1 end = 2 mid = 3，此时 end = mid
        return end;
    }
}
