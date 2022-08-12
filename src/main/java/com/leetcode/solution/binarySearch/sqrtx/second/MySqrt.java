package com.leetcode.solution.binarySearch.sqrtx.second;

import com.leetcode.solution.binarySearch.sqrtx.MySqrtTemplate;

public class MySqrt extends MySqrtTemplate {
    // 思路：二分查找。
    // n/2 * n/2 > n => [1, n/2]
    // n/2 * n/2 < n => [n/2, n]
    @Override
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }

        if (x == 0) {
            return 0;
        }

        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end <= x / end) {
            return end;
        }

        return start;
    }
}
